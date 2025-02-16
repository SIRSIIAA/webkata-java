package sirsiiaa.webkata.java.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class PlayerConfigImportSelector implements ImportSelector {
    /*
     * 此方法返回需要由@Import注解导入的配置类全类名数组，可以从配置文件中读取值，动态调整配置类
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
