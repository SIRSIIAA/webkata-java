package sirsiiaa.webkata.java.beans;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class BeanA implements InitializingBean {

    public void initMethod() {
        System.out.println("Bean A initialized by init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean A initialized by interface method");
    }

    @PostConstruct
    public void initBean() {
        System.out.println("Bean A initialized by @PostConstruct");
    }
}
