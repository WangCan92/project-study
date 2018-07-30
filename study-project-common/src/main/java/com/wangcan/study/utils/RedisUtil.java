package com.wangcan.study.utils;

import com.wangcan.study.common.constaant.SignConstant;
import com.wangcan.study.common.exception.CommonExceptionMsg;
import com.wangcan.study.common.exception.CommonRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import redis.clients.jedis.JedisCommands;

import java.util.Collections;

/**
 * @author wangcan
 */
@Slf4j
public class RedisUtil {
    private static final String SUCCESS = "OK";

    private static final long DEFAULT_EXPIRE_MILLISECOND = 8000;



    public static String concatKey(String... keyElement){
        return StringUtils.join(keyElement,SignConstant.COLON);
    }


    public static void tryLock(String key,String value,long expireMillisecond){
        StringRedisTemplate redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
        Object result = redisTemplate.execute((RedisCallback<String>) connection -> {
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            return commands.set(key, value, "NX", "PX", expireMillisecond);
        });

        if (!SUCCESS.equals(result)) {
            throw new CommonRuntimeException(CommonExceptionMsg.COMMON_EXCEP.getCode(),CommonExceptionMsg.COMMON_EXCEP.getMsg());
        }

        log.info("[tryLock success] key {} requestId {} expireMillisecond {}", key, value, expireMillisecond);
    }

    public static void tryLock(String key,String value){
        StringRedisTemplate redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
        Object result = redisTemplate.execute((RedisCallback<String>) connection -> {
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            return commands.set(key, value, "NX", "PX", DEFAULT_EXPIRE_MILLISECOND);
        });

        if (!SUCCESS.equals(result)) {
            throw new CommonRuntimeException(CommonExceptionMsg.COMMON_EXCEP.getCode(),CommonExceptionMsg.COMMON_EXCEP.getMsg());
        }

        log.info("[tryLock success] key {} requestId {} expireMillisecond {}", key, value, DEFAULT_EXPIRE_MILLISECOND);
    }

    public static void releaseLock(String key, String requestId) {
        StringRedisTemplate redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
        DefaultRedisScript<Boolean> releaseLockScript = new DefaultRedisScript<>();
        releaseLockScript.setScriptText("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return false end");
        releaseLockScript.setResultType(Boolean.class);
        boolean result = redisTemplate.execute(releaseLockScript, Collections.singletonList(key), requestId);
        if (result) {
            log.info("[releaseLock success] key {} requestId {}", key, requestId);
        } else {
            log.info("[releaseLock failed] key {} requestId {}", key, requestId);
        }
    }
}
