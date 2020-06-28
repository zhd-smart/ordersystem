package com.zhdsmart.feign;

import com.zhdsmart.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping(value = "/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping(value = "/user/findById/{userId}")
    public User findById(@PathVariable("userId") int userId);

    @GetMapping(value = "/user/count")
    public int count();

    @PostMapping(value = "/user/save")
    public void save(@RequestBody User user);

    @PutMapping(value = "/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping(value = "/user/deleteById/{userId}")
    public void deleteById(@PathVariable("userId") int userId);
}
