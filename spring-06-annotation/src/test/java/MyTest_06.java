import com.yau.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/*.xml")
public class MyTest_06 {
    @Autowired
    private User user;

    @Test
    public void test1() {
        assertNotNull(user);
        System.out.println(user.name);
    }
}
