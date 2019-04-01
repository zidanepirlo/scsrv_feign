/**
 * testService
 *
 * @author yuanqing
 * @create 2019-03-31 08:07
 **/

import com.yuan.springcloud.scsrv.service.ITestService;
import com.yuan.springcloud.scsrv.web.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class testService {

    @Autowired
    private ITestService testService;

    @Test
    public void TestInsertUserGradeForTransaction() throws Exception{
        testService.insertUserGradeForTransaction();
    }
}
