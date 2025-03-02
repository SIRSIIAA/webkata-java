package sirsiiaa.webkata.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("param")
@Controller
@ResponseBody
public class ParamController {
    /*
     * handlerAdapter 将参数处理好之后传递给handler
     * handler使用参数表接受所有的参数： param参数、path参数、json参数、cookie参数、servlet共享域对象
     */

    @PostMapping("login")
    public String login(String username, String password) {
        return "login: " + username + ", " + password;
    }
}
