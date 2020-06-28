package com.zhdsmart.service;

import com.zhdsmart.entity.Order;

import java.util.List;

public interface OrderService {

    public void save(Order order);

    public List<Order> findAll(int index, int limit,int userId);

    public int countByUserId(int userId);

    public void deleteById(int orderId);

    public List<Order> findAllByState(int index,int limit);

    public void updateState(int orderId);

    public int count();
}
