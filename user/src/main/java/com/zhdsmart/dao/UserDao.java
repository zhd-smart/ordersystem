package com.zhdsmart.dao;

import com.zhdsmart.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public List<User> findAll(int index,int limit);

    public User findById(int userId);

    public int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(int userId);
}
