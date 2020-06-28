package com.zhdsmart.controller;

import com.zhdsmart.entity.Menu;
import com.zhdsmart.entity.Order;
import com.zhdsmart.entity.OrderVo;
import com.zhdsmart.entity.User;
import com.zhdsmart.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping(value = "/save/{menuId}")
    public String save(@PathVariable("menuId") int menuId, HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setMenuId(menuId);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @ResponseBody
    @GetMapping(value = "/findAll")
    public OrderVo findAll(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page - 1)*limit;
        return orderFeign.findAll(index,limit,user.getUserId());
    }

    @GetMapping(value = "/findAllByState")
    @ResponseBody
    public OrderVo findAllByState(@RequestParam int page,@RequestParam int limit){
        int index = (page - 1)*limit;
        return orderFeign.findAllByState(index,limit);
    }

    @GetMapping(value = "/updateState/{orderId}")
    public String uodateState(@PathVariable("orderId") int orderId){
        orderFeign.updateState(orderId);
        return "redirect:/menu/redirect/order-handler";
    }
}
