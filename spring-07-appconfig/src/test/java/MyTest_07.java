import com.yau.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.yau.config.MyConfig.class)
public class MyTest_07 {
    @Autowired
    private User user;
    @Test

    public void test1() {
        Assert.assertNotNull(user);
        System.out.println(user.getName());
    }
}
