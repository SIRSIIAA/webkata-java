package sirsiiaa.webkata.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sirsiiaa.webkata.java.beans.PlayerBean;

@Service
public class PlayerService implements CreatureService {
    @Autowired // <bean ref="playerBean" class="PlayerBean" Autowired根据类型查找Bean
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

    }
}
