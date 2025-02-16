import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sirsiiaa.webkata.java.config.jdbc.SpringJDBCConfig;
import sirsiiaa.webkata.java.controller.PlayerController;

/*
 * 配置测试类/配置xml文件
 */
@SpringJUnitConfig(classes = SpringJDBCConfig.class)
public class SpringPlayerTest {
    /*
     * 自动获取Bean
     */
    @Autowired
    private PlayerController playerController;
    @Test
    public void test() {
        playerController.play();
    }
}
