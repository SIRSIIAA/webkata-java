package sirsiiaa.webkata.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 声明当前类为配置类
@Configuration
// <context:property-placeholder location="player.property", 注册配置文件
@PropertySource("player.properties")
// <context:component-scan base-package="sirsiiaa.webkata.java", 注册包扫描
@ComponentScan(
        basePackages = {"sirsiiaa.webkata.java"}
)
public class SpringConfig {

}
