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
}
