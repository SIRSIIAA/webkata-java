package sirsiiaa.webkata.java.controller;

import org.springframework.stereotype.Controller;
import sirsiiaa.webkata.java.beans.PlayerBean;
import sirsiiaa.webkata.java.service.PlayerService;

/*
 * controller 负责处理玩家的输入交互请求、将结果渲染输出
 */
@Controller
public class PlayerController {
    private PlayerService playerService;
    private PlayerBean playerBean;

    public PlayerController() {
    }

    public PlayerController(PlayerService playerService, PlayerBean playerBean) {
        this.playerService = playerService;
        this.playerBean = playerBean;
    }

    public void play() {
        System.out.println(playerBean.getName());
        playerService.active();
    }
}
