package com.zhdsmart.feign;

import com.zhdsmart.entity.Menu;
import com.zhdsmart.entity.MenuVo;
import com.zhdsmart.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient(value = "menu") //这一步相当与到了端口那一步，具体的路径也要写上
public interface MenuFeign {
    @GetMapping(value = "/menu/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping(value = "/menu/deleteById/{menuId}")
    public MenuVo deleteById(@PathVariable("menuId") int menuId);

    @GetMapping(value = "/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping(value = "/menu/save")
    public void save(Menu menu);

    @GetMapping(value = "/menu/findById/{menuId}")
    public Menu findById(@PathVariable("menuId") int menuId);

    @PutMapping(value = "/menu/update")
    public void update(Menu menu);
}
