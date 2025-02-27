package sirsiiaa.webkata.java.controller;

import org.springframework.web.bind.annotation.*;
import sirsiiaa.webkata.java.pojo.User;

@RestController
@RequestMapping("user")
public class PracticeController {
    @GetMapping
    public String queryByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "50") Integer size) {
        return "queryByPage: " + page + ", " + size;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        return "addUser: " + user;
    }

    @GetMapping("{id}")
    public String queryById(@PathVariable Integer id) {
        return "queryById: " + id;
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Integer id) {
        return "deleteById: " + id;
    }

    @GetMapping("search")
    public String search(@RequestParam Integer page, @RequestParam Integer size, String keyword) {
        return "search: " + keyword + ", " + page + ", " + size;
    }
}
