package com.zhdsmart.controller;

import com.zhdsmart.entity.User;
import com.zhdsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/index")
    public String index(){
        return this.port;
    }

    @GetMapping(value = "/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit")int limit){
        return userService.findAll(index,limit);
    }

    @GetMapping(value = "/findById/{userId}")
    public User findById(@PathVariable("userId") int userId){
        return userService.findById(userId);
    }

    @GetMapping(value = "/count")
    public int count(){
        return userService.count();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping(value = "/deleteById/{userId}")
    public void deleteById(@PathVariable("userId") int userId){
        userService.deleteById(userId);
    }
}
