package sirsiiaa.webkata.java.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("npc")
/*
 * 通过Scope注解指定单例/多例，该注解同样可以修饰方法
 * ConfigurableBeanFactory.SCOPE_PROTOTYPE 为多例
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NPCBean implements Creature {
    @Value("${npc.name}")
    private String name;

    @Override
    public String getName() {
        return name;
    }
}
