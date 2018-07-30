package ping;

import com.wangcan.study.ServiceApplication;
import com.wangcan.study.service.PingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author wangcan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class PingTest {
    @Resource
    private PingService pingService;

    @Test
    public void pingTest(){
        pingService.tryLock("trylock","123456");
    }
}
