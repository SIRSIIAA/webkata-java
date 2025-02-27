package sirsiiaa.webkata.java.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sirsiiaa.webkata.java.pojo.User;

//@Controller
//@ResponseBody
@RestController // RestController = @Controller + @ResponseBody的组合
@RequestMapping("json")
public class JsonController {
    /*
     * 接受JSON参数：
     * 1. 导入jackson依赖
     * 2. 配置JSON相关adapter
     * 3. 若使用实体类接受JSON，标记参数为RequestBody
     * 返回JSON：
     * 1. 直接返回实体类，实体类需要是任何可以转化为JSON的数据类型，对象、数组、集合等
     * 2. 在方法、类上添加@ResponseBody，标记该类中的全部handler或当前handler返回的响应体
     */
    @PostMapping("save")
    public User save(@RequestBody User user) {
        System.out.println(user);
        //直接返回JSON
        return user;
    }
}
