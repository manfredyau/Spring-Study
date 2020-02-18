import com.yau.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Hello hello = (Hello) applicationContext.getBean("hello");
        System.out.println("print:");
        System.out.println(hello.getStr());
    }

}
