import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.beans.PlayerBean;
import sirsiiaa.webkata.java.service.CommonService;
import sirsiiaa.webkata.java.service.CreatureService;
import sirsiiaa.webkata.java.service.PlayerService;

public class PlayerTest {
    @Test
    public void test01() {
        var config = "player-beans-01.xml";
        var context = new ClassPathXmlApplicationContext(config);
        var player =  context.getBean(PlayerBean.class);
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
}
