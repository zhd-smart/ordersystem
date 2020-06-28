package com.zhdsmart.serviceImpl;

import com.netflix.discovery.converters.Auto;
import com.zhdsmart.dao.UserDao;
import com.zhdsmart.entity.User;
import com.zhdsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String password) {
        return userDao.login(userName,password);
    }
}
