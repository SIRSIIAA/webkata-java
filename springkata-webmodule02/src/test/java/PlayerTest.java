import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.beans.PlayerBean;
import sirsiiaa.webkata.java.config.SpringConfig;
import sirsiiaa.webkata.java.config.jdbc.SpringJDBCConfig;
import sirsiiaa.webkata.java.controller.PlayerController;
import sirsiiaa.webkata.java.service.CommonService;
import sirsiiaa.webkata.java.service.PlayerService;

public class PlayerTest {
    @Test
    public void test01() {
        var config = "player-beans-01.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var player = context.getBean(PlayerBean.class);
    }

    @Test
    public void test02() {
        var config = "player-services-01.xml";
        var context = new ClassPathXmlApplicationContext(config);
        PlayerService playerService = context.getBean(PlayerService.class);
        System.out.println(playerService.getName());
    }

    @Test
    public void test03() {
        var config = "player-services-01.xml";
        var context = new ClassPathXmlApplicationContext(config);
        CommonService bean = context.getBean(CommonService.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test04() {
        /*
         * 注册同时指定配置文件
         */
        var contex = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(contex.getBean(PlayerService.class).getName());

        /*
         * 也可以分步指定，然后手动调用refresh触发容器创建
         */
        var context2 = new AnnotationConfigApplicationContext();
        context2.register(SpringConfig.class);
        context2.refresh();
    }

    @Test
    public void test05() {
        var context = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
        var playerController = context.getBean(PlayerController.class);
        playerController.play();
    }

    @Test
    public void test06() {
        var context = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
        var commonService = context.getBean(CommonService.class);
        System.out.println(commonService.getName());
    }
}
