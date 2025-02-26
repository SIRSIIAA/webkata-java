package sirsiiaa.webkata.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 1. 在JavaWeb中，Controller必须要实现HttpServlet接口 --> 创建动态资源 --> 由tomcat调用
 * 2. 引入SpringMVC之后，Controller不需要实现其他接口，只作为常规类出现 --> 定义handler方法 --> handlerAdapter调用handler
 *    --> dispatcherServlet调用adapter --> 由tomcat调用
 *
 * Step1 声明handler
 * Step2 在mapper中注册
 * Step3 等待adapter调用
 */
@Controller
public class GreetingController {
    /*
     * 使用RequestMapping注解向mapper中注册路径--handler
     */
    @ResponseBody
    @RequestMapping("springmvc/greetingTo")
    public String greeting(String name) {
        System.out.println("handler greetingTo reached");
        /*
         * 当返回String时，默认会识别为指向jsp视图的一个路径
         * 需要通过注解ResponseBody来指出返回的是一个请求体
         */
        return "<h1>Hello Spring MVC " + name + "</h1>";
    }

    @ResponseBody
    @RequestMapping("springmvc/greeting")
    public String greetingNoName(){
        System.out.println("handler greeting reached");
        return "<h1 margin-left: 100px>Hello Spring MVC </h1>";
    }
}
