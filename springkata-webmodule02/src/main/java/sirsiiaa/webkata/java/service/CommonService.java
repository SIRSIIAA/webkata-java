package sirsiiaa.webkata.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sirsiiaa.webkata.java.beans.Creature;

@Service
public class CommonService implements CreatureService {
    /*
     * Creature存在两个子类，PlayerBean以及NPCBean
     * 两个子类都通过Component注解修饰后以单例形式存在于IoC中
     * 当调用Autowired时，仅通过clazz无法唯一确定注入实例
     * 此处会进一步考察需要注入的变量名，若变量名可以命中其中一个实例
     * 则将该唯一实例注入
     *
     * 若均失败，抛出异常
     *
     * 可以使用@Autowired的子注解，Qualifier直接指定要注入的bean id以避免异常
     *
     * Java提供了@Resource注解，制定了IoC、DI引用类型注入的规范，Spring为其提供了实现
     *
     * @Resource是@Autowired 及 @Qualifier功能的并集
     * 1.若不为@Resource的name属性赋值，则取用@Autowired逻辑
     * 2.若为name属性赋值，则取用@Autowired + @Qualifier的逻辑
     *
     * 这三个注解用的都比较少，大部分应用场景实质上都是单例，并且Resource注解与Java版本有强依赖
     * 仅有JDK8、9、10包含了Resource，其余JDK版本未包含，若使用需要主动引入外部依赖
     */
//    @Autowired
//    private Creature npc; // NPCBean的单例id为npc，名称命中，不会产生异常
//
//    @Override
//    public String getName() {
//        return npc.getName();
//    }

    @Autowired
    @Qualifier("playerBean")
    private Creature creature; // NPCBean的单例id为npc，名称命中，不会产生异常

    @Override
    public String getName() {
        return creature.getName();
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public String getRole() {
        return "";
    }

    @Override
    public void active() {

    }
}
