package com.zhdsmart.dao;

import com.zhdsmart.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    public void save(Order order);

    public List<Order> findAll(int index,int limit,int userId);

    public int countByUserId(int userId);

    public void deleteById(int orderId);

    public List<Order> findAllByState(int index,int limit);

    public void updateState(int orderId);

    public int count();
}
