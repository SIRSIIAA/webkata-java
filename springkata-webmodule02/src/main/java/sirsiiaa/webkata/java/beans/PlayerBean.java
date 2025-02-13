package sirsiiaa.webkata.java.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // <bean id="playerBean"
/*
 * 1. 单例id为 playerBean，小驼峰命名的小写类名，可以在Component注解中直接指定值
 */
public class PlayerBean implements Creature {
    /*
     * 读取配置文件，若不指定默认值将会产生BeanDefinition异常
     */
    @Value("${player.name:default name}") // <property name="playerName" value="${player.name:default name}"
    private String name;
    private int rank;
    private String role;

    @Override
    public String getName() {
        return name;
    }
}
