package service;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sirsiiaa.webkata.java.dao.PlayerDAO;

public class DAOTest {
    @Test
    public void test() {
        var path = "player-dao-1.xml";
        var context = new ClassPathXmlApplicationContext(path);
        var player = context.getBean("player1", PlayerDAO.class);
        System.out.println(player.getName());
    }
}
