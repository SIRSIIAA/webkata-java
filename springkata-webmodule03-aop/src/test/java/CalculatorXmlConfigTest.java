import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.service.Calculator;
import sirsiiaa.webkata.java.service.impl.CalculatorPureImpl;

public class CalculatorXmlConfigTest {
    @Test
    public void test() {
        var config = "calculator.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var cal = context.getBean(Calculator.class);
        System.out.println(cal.add(10, 20));
    }
}
