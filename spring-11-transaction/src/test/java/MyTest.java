import com.yau.mapper.UserMapper;
import com.yau.pojo.User;
import com.yau.service.UserService;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;
import java.util.List;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SqlSessionTemplate sqlSession = context.getBean("sqlSession", SqlSessionTemplate.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        // 用了 AOP 的話，這裡不宜再使用實現類的類型來做聲明，應用 interface 的類型
        UserService userService = context.getBean("userService", UserService.class);
        List<User> users = userService.findUser();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /*
     * 測試傳播行為*/
    @Test
    public void testPropagation() throws Throwable {
        // 生成 cglib 所產生的 .class 文件可以直接將以下代碼置於 JUnit 單元測試中。
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://tmp");
        // 使用 JUnit 時，以下這段代碼是不會起效的，需要在 main() 中才能起到作用
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        List<User> users = userService.findUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        List<User> users = userService.findUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGeneratingProxyClass() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("$Proxy0.class全名: " + Proxy.getProxyClass(UserService.class.getClassLoader(), UserService.class));
    }
}
