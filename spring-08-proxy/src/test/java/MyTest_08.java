import com.yau.proxy.Landlord;
import com.yau.proxy.LandlordProxy;
import com.yau.proxy.Rent;
import com.yau.proxy.dynamic.MyHandler;
import org.junit.Test;

public class MyTest_08 {
    @Test
    public void test1() {
        Rent proxy = new LandlordProxy(new Landlord());
        proxy.rent();
    }

    @Test
    public void test2() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        MyHandler myHandler = new MyHandler();
        Landlord landlord = new Landlord();
        Rent proxy = (Rent) myHandler.bind(landlord);
        proxy.rent();
    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        MyHandler myHandler = new MyHandler();
        Landlord landlord = new Landlord();
        Rent proxy = (Rent) myHandler.bind(landlord);
        proxy.rent();
    }
}
