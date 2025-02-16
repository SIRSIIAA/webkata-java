package sirsiiaa.webkata.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sirsiiaa.webkata.java.beans.PlayerBean;

@Service
public class PlayerService implements CreatureService {
    @Autowired // <bean ref="playerBean" class="PlayerBean" Autowired根据类型查找Bean
    // 默认情况/不指定值的情况下， Autowired的required参数默认为true，当装配失败时，抛出NoSuch异常
    // 若显式指定为 false， 则赋null， 不要显式指定！
    private PlayerBean playerBean;

    @Override
    public String getName() {
        return playerBean.getName();
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
        System.out.println("player is active: " + playerBean.getName());
    }

    public PlayerBean getPlayer() {
        return playerBean;
    }
}
