package com.zhdsmart.serviceImpl;

import com.zhdsmart.dao.UserDao;
import com.zhdsmart.entity.User;
import com.zhdsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(int index,int limit) {
        return userDao.findAll(index,limit);
    }

    @Override
    public User findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }
}
