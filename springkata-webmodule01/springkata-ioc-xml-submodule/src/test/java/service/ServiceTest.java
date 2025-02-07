package service;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.service.AbstractUserService;
import sirsiiaa.webkata.java.service.CommonService;
import sirsiiaa.webkata.java.service.ComplexService;
import sirsiiaa.webkata.java.service.UserService;
import sirsiiaa.webkata.java.service.servicefactorybean.ComplexServiceFactoryBean;

public class ServiceTest {
    @Test
    public void test01() {

        /*
         * 创建容器
         */
        var config = "user-service.xml";
        var config1 = "user-service-1.xml";

        //M1
        //ClassPathXmlApplicationContext(String... configLocations)
        //这要求你必须在创建容器时，确切指定配置文件的位置
        var context = new ClassPathXmlApplicationContext(config);

        //M2
        //你也可以先创建容器，然后在恰当的时机再指定配置文件的位置
        //诸多构造函数的调用最终归至ClassPathApplicationContext，其内部又进行了三部分调用
        //1. super(parent)，调用父构造函数
        //2. setConfigLocations(configLocations)，指定配置文件
        //3. refresh()，创建容器的步骤，均位于此

        //1. 调用无参构造器，获取一个容器
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();

        //2. 明确配置文件的位置
        //ClassPathXmlApplicationContext的继承链如下，由下至上分别为
        //ClassPathXmlApplicationContext
        //--> AbstractXmlApplicationContext
        //--> AbstractRefreshableConfigApplicationContext
        //setConfigLocations，定义于AbstractRefreshableConfigApplicationContext中
        context1.setConfigLocations(config1);

        //3. 触发容器内容的更新
        context1.refresh();

        /*
         * 获取组件
         */
        //在下述方法调用中，若无法定位确切的组件信息（空定义、冗余定义），都会直接抛出异常，不会返回空值
        //使用组件时，不需要进行非空判断
        //get by id, return an Object
        //low using frequency
        //若未配置相关组件，调用此方法会抛出异常NoSuchBeanDefinitionException
        Object userServiceSt = context.getBean("userService");

        //get by value(id + clazz), return an exact type Object
        UserService userServiceNd = context.getBean("userService", UserService.class);

        //get by clazz, return an Object of the clazz
        //high using frequency
        //若配置了同一类型的多个组件，调用此方法会抛出异常 NoUniqueBeanDefinitionException
        //get by clazz 使用 instanceof 来判断是组件是否为clazz的实例
        //若component instance of clazz为true，即可返回
        //因此clazz可以为希望查找类的接口、父类
        var userServiceRd = context.getBean(UserService.class);
        var userServiceGetByInterface = context.getBean(CommonService.class);
        var userServiceGetByBase = context.getBean(AbstractUserService.class);


        //若没有为bean指定其他的属性，返回同一个组件
        System.out.println(userServiceSt == userServiceNd);
        System.out.println(userServiceRd == userServiceNd);
        System.out.println(userServiceGetByInterface == userServiceNd);
        System.out.println(userServiceGetByBase == userServiceNd);
    }

    @Test
    public void test02() {
        var config = "user-service-with-value.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var service = context.getBean(UserService.class);

        System.out.println(service.getServiceName());
    }

    @Test
    public void test03() {
        var config = "complex-service.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var complexService = context.getBean(ComplexService.class);
        System.out.println(complexService);
        var complexServiceFactoryBean = context.getBean(ComplexServiceFactoryBean.class);
        var complexServiceFactoryBean1 = context.getBean("&complexService");
        System.out.println(complexServiceFactoryBean);
    }
}
