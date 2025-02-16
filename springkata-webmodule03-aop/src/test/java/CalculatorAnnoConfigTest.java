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
        System.out.println(calculator.add(1, 2));
    }
}
