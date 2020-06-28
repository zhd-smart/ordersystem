package com.zhdsmart.serviceImpl;

import com.zhdsmart.dao.OrderDao;
import com.zhdsmart.entity.Order;
import com.zhdsmart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findAll(int index, int limit,int userId) {
        return orderDao.findAll(index,limit,userId);
    }

    @Override
    public int countByUserId(int userId) {
        return orderDao.countByUserId(userId);
    }

    @Override
    public void deleteById(int orderId) {
        orderDao.deleteById(orderId);
    }

    @Override
    public List<Order> findAllByState(int index, int limit) {
        return orderDao.findAllByState(index,limit);
    }

    @Override
    public void updateState(int orderId) {
        orderDao.updateState(orderId);
    }

    @Override
    public int count() {
        return orderDao.count();
    }

}
