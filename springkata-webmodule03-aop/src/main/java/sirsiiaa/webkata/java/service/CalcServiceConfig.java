package sirsiiaa.webkata.java.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sirsiiaa.webkata.java.service.impl.CalculatorPureImpl;

@Configuration
@ComponentScan("sirsiiaa.webkata.java.service")
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy
public class CalcServiceConfig {
    @Bean
    public Calculator calculator() {
        return new CalculatorPureImpl();
    }
}
