import com.yau.config.MyConfig;
import com.yau.mapper.UserMapper;
import com.yau.pojo.Group;
import com.yau.pojo.User;
import com.yau.service.UserService;
import com.yau.service.UserServiceImpl;
import com.yau.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest_10 {
    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
//        User user = userService.getUser(1);
        User user = ((UserServiceImpl) userService).getUserByTemplate(1);
        System.out.println(user);
    }

    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Group bean = context.getBean(Group.class);
        User user = bean.getUser();
        System.out.println(user);
    }

    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService2 = (UserService) context.getBean("userService2");
        User user = userService2.getUser(1);
        System.out.println(user);
    }
}
