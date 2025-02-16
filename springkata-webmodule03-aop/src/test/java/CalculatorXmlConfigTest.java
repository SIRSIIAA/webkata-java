import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.service.Calculator;

public class CalculatorXmlConfigTest {
    @Test
    public void test() {
        var config = "calculator.xml";
        var context = new ClassPathXmlApplicationContext(config);
        Calculator cal = context.getBean("calculator", Calculator.class);
//        var cal = context.getBean(Calculator.class);
//        此时context中存在两个满足条件的单例对象，一个是CalculatorPureImpl，另一个是动态代理生成的同接口实现类实例
        System.out.println(cal.add(10, 20));
    }
}
