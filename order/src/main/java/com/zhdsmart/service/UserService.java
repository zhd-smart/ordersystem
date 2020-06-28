package com.zhdsmart.service;

import com.zhdsmart.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll(int index, int limit);

    public User findById(int userId);

    public int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(int userId);
}
