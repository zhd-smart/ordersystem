package com.zhdsmart.controller;

import com.zhdsmart.entity.Admin;
import com.zhdsmart.entity.User;
import com.zhdsmart.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping(value = "/login")
    public String  login(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(userName,password,type);
        LinkedHashMap<String ,Object> hashMap = (LinkedHashMap)object;
        String result = null;
        if(object == null){
            result = "login";
        }
        else{
            switch (type){
                case "user":
                    User user = new User();
                    int userId = (int) hashMap.get("userId");
                    String nickName = (String) hashMap.get("nickName");
                    user.setUserId(userId);
                    user.setNickName(nickName);
                    session.setAttribute("user",user);
                    result = "index2.html";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    int adminId = (int) hashMap.get("adminId");
                    String userName2 = (String) hashMap.get("userName");
                    admin.setAdminId(adminId);
                    admin.setUserName(userName2);
                    session.setAttribute("admin",admin);
                    result =  "main.html";
                    break;
            }
        }
        return result;
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
