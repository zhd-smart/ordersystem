package com.zhdsmart.controller;

import com.zhdsmart.service.AdminService;
import com.zhdsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/index")
    public String index(){
        return this.port;
    }

    @GetMapping(value = "/login/{userName}/{password}/{type}")
    public Object login(@PathVariable("userName") String userName,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "user":
                object = userService.login(userName,password);
                break;
            case "admin":
                object = adminService.login(userName,password);
                break;
        }
        return object;
    }
}
