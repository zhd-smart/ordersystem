package com.zhdsmart.controller;

import com.zhdsmart.entity.User;
import com.zhdsmart.entity.UserVo;
import com.zhdsmart.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") int page, @RequestParam("limit")int limit){
        int index = (page-1)*limit;
        UserVo userVo = new UserVo();
        userVo.setCode(0);
        userVo.setCount(userFeign.count());
        userVo.setMsg("");
        userVo.setData(userFeign.findAll(index,limit));
        return userVo;
    }

    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping(value = "/findById/{userId}")
    public User findById(@PathVariable("userId") int userId){
        return userFeign.findById(userId);
    }

    @GetMapping(value = "/count")
    public int count(){
        return userFeign.count();
    }

    @PostMapping(value = "/save")
    public String save(User user){
        user.setRegisterDate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user-manage";
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody User user){
        userFeign.update(user);
    }

    @GetMapping(value = "/deleteById/{userId}")//因为前端使用超链接方式所以用get请求
    public String deleteById(@PathVariable("userId") int userId){
        userFeign.deleteById(userId);
        return "redirect:/user/redirect/user-manage";
    }
}
