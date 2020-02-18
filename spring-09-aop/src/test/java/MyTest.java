import com.yau.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // 如果使用了 aop，實際上得到的是代理對象；如果沒用 aop，則仍是真實對象
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        System.out.println("Bean 的實際類型是：" + userServiceImpl.getClass());
        userServiceImpl.add();
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.delete(312);
    }
}
