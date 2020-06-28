package com.zhdsmart.feign;

import com.zhdsmart.entity.Order;
import com.zhdsmart.entity.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping(value = "/order/save")
    public void save(@RequestBody Order order);

    @GetMapping(value = "/order/findAll/{index}/{limit}/{userId}")
    public OrderVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("userId") int userId);

    @GetMapping(value = "/order/findAllByState/{index}/{limit}")
    public OrderVo findAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit);

    @GetMapping(value = "/order/updateState/{orderId}")
    public void updateState(@PathVariable("orderId") int orderId);
}
