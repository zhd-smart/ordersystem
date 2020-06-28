package com.zhdsmart.controller;

import com.zhdsmart.entity.Menu;
import com.zhdsmart.entity.MenuVo;
import com.zhdsmart.entity.Type;
import com.zhdsmart.service.MenuService;
import com.zhdsmart.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private TypeService typeService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/index")
    public String index(){
        return "menu的端口为：" + this.port;
    }

    @GetMapping(value = "/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        List<Menu> list = menuService.findAll(index,limit);
        return new MenuVo(0,"",menuService.count(),menuService.findAll(index,limit));
    }

    @GetMapping(value = "/count")
    public int count(){
        return menuService.count();
    }

    @GetMapping(value = "/findById/{menuId}")
    public Menu findById(@PathVariable("menuId") int menuId){
        return menuService.findById(menuId);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Menu menu){
        menuService.save(menu);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Menu menu){
        menuService.update(menu);
    }

    @DeleteMapping(value = "/deleteById/{menuId}")
    public void deleteById(@PathVariable("menuId") int menuId){
        menuService.deleteById(menuId);
    }

    @GetMapping(value = "/findTypes")
    public List<Type> findTypes(){
        return typeService.findAll();
    }
}
