package com.zhdsmart.controller;

import com.zhdsmart.entity.Order;
import com.zhdsmart.entity.OrderVo;
import com.zhdsmart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/index")
    public String index(){
        return "order的端口为：" + this.port;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Order order){
        order.setCreateDate(new Date());
        orderService.save(order);
    }

    @GetMapping(value = "/findAll/{index}/{limit}/{userId}")
    public OrderVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("userId") int userId){
        OrderVo orderVo = new OrderVo();
        orderVo.setCode(0);
        orderVo.setMsg("");
        orderVo.setCount(orderService.countByUserId(userId));
        orderVo.setData(orderService.findAll(index,limit,userId));
        return orderVo;
    }

    @GetMapping(value = "/countByUserId/{userId}")
    public int countByUserId(@PathVariable("userId") int userId){
        return orderService.countByUserId(userId);
    }

    @GetMapping(value = "/findAllByState/{index}/{limit}")
    public OrderVo findAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit){
        OrderVo orderVo = new OrderVo();
        orderVo.setCode(0);
        orderVo.setMsg("");
        orderVo.setCount(orderService.count());
        orderVo.setData(orderService.findAllByState(index,limit));
        return orderVo;
    }

    @GetMapping(value = "/updateState/{orderId}")
    public void updateState(@PathVariable("orderId") int orderId){
        orderService.updateState(orderId);
    }
}
