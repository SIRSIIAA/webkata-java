package sirsiiaa.webkata.java.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import sirsiiaa.webkata.java.beans.Creature;
import sirsiiaa.webkata.java.beans.NPCBean;
import sirsiiaa.webkata.java.beans.PlayerBean;
import sirsiiaa.webkata.java.controller.PlayerController;
import sirsiiaa.webkata.java.service.CommonService;
import sirsiiaa.webkata.java.service.PlayerService;

import javax.sql.DataSource;

/*
 * 使用配置类配置三方类
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("sirsiiaa.webkata.java")
public class SpringJDBCConfig {
    /*
     * M1：可以使用和xml配置同样的方式对Value进行配置
     * 缺点是字段对当前配置类中的全部@Bean方法都可见
     * M2：@Bean的方法若存在非复杂对象参数，所有的参数必须以@Value修饰，通过此修饰的参数只对当前方法可见
     *
     * @Bean的参数注解语义为自动装配该参数
     *
     * 可以为@Bean指定name参数，该参数为创建对象的id，默认为方法名，同样可以指定init、destroy方法
     *
     */
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // <bean ==> java method ==> return third-obj
    // 类比FactoryBean接口的getObject方式理解
    @Bean(name = "ds", initMethod = "", destroyMethod = "")
    /*
     * 配置当前方法返回多例对象
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSource dataSource(
            @Value("${jdbc.url}")
            String url,
            @Value("${jdbc.driver}")
            String driverClassName
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public PlayerController playerController(
            /*
             * 若为非Java原生对象，@Autowired注解可以省略
             */
            @Autowired PlayerService playerService,
            PlayerBean playerBean
    ) {
        return new PlayerController(playerService, playerBean);
    }

    @Bean
    public CommonService commonService(
            /*
             * 若注入非单例实例，则通过id查找
             */
            @Autowired
            Creature npc
    ) {
        return new CommonService();
    }

    @Bean
    public PlayerBean playerBean() {
        return new PlayerBean();
    }

    @Bean(name = "npc")
    public NPCBean npcBean() {
        return new NPCBean();
    }

}
