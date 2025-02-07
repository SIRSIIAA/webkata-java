package beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.beans.BeanA;

public class BeansTest {
    @Test
    public void testBeansA() {
        var config = "bean-a.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var beanA = context.getBean(BeanA.class);
    }
}
