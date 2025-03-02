package sirsiiaa.webkata.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
/*
 * RequestMapping可以修饰类，当放置在类上时，该类中配置的全部Controller都会以将此路径附加至前导
 * 可以提取公共地址，是可选行为
 */
@RequestMapping("user")
public class PathController {
    /*
     * 登录功能 user/login
     *
     * 1. 在使用WebServlet时，路径必须以/开始
     * 2. 使用SpringMVC的封装时，路径可以省略前导的/，也可以选择保留
     *
     * 请求路径的前导部分一般存在逻辑划分，从项目根路径开始->模块路径->功能点
     * 因此位于同一个Controller中的handler所需配置的reqMap会有部分代码冗余
     */
//    @RequestMapping("user/login")
//    @ResponseBody
//    public String login() {
//        System.out.println("login reached");
//        return "login";
//    }
    @RequestMapping("login")
    @ResponseBody
    public String login() {
        System.out.println("login reached");
        return "login";
    }

    /*
     * 注册功能 user/registry
     * 可以配置接受的请求方式，默认接受所有类型的请求
     * 若使用不接受的请求方式请求handler，则返回405，浏览器默认只会发送get请求
     */
    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String register() {
        System.out.println("register reached");
        return "register";
    }

    /*
     * 查询方法 user
     * 若是handler的路径与类相同，则可以不指定RequestMapping的值，但是RequestMapping注解必须添加
     */
    @RequestMapping
    @ResponseBody
    public String list() {
        System.out.println("list reached");
        return "user list";
    }

    /*
     * handler可以配置多个路径，类似servlet
     */
    @RequestMapping({"path1", "path2"})
    @ResponseBody
    public String multi() {
        System.out.println("list reached");
        return "user list";
    }

    /*
     * 可以配置模糊路径
     * * 向下模糊一层
     * ** 向下模糊任意层
     */
    @RequestMapping("user/*")
    @ResponseBody
    public String receiver() {
        System.out.println("list reached");
        return "user list";
    }

    /*
     * RequestMapping 存在4个子注解
     * RequestMapping(method = RequestMethod.GET)
     * PostMapping、GetMapping、PullMapping、DeleteMapping，此4个子注解只能修饰方法
     */
}
