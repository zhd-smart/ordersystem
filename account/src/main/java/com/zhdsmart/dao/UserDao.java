package com.zhdsmart.dao;

import com.zhdsmart.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public User login(String userName,String password);
}
