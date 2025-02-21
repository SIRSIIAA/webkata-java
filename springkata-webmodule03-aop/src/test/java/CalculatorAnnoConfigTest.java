import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sirsiiaa.webkata.java.service.CalcServiceConfig;
import sirsiiaa.webkata.java.service.Calculator;

@SpringJUnitConfig(CalcServiceConfig.class)
public class CalculatorAnnoConfigTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        System.out.println(calculator.div(1, 0));
    }

    @Test
    public void test2() {
        try {
            System.out.println(calculator.mul(10,10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
