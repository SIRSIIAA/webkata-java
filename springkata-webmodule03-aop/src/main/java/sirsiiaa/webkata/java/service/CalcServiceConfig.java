package sirsiiaa.webkata.java.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sirsiiaa.webkata.java.service.impl.CalculatorPureImpl;

@Configuration
@ComponentScan("sirsiiaa.webkata.java.service")
public class CalcServiceConfig {
    @Bean
    public Calculator calculator() {
        return new CalculatorPureImpl();
    }
}
