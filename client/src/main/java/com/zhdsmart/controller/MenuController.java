package com.zhdsmart.controller;

import com.zhdsmart.entity.Menu;
import com.zhdsmart.entity.MenuVo;
import com.zhdsmart.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return menuFeign.findAll(index,limit);
    }

    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping(value = "/deleteById/{menuId}")
    public String deleteById(@PathVariable("menuId") int menuId){
        menuFeign.deleteById(menuId);
        return "redirect:/menu/redirect/menu-manage";
    }

    @GetMapping(value = "/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-add");
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu-manage";
    }

    @GetMapping(value = "/findById/{menuId}")
    public ModelAndView findById(@PathVariable("menuId") int menuId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu-update");
        modelAndView.addObject("menu",menuFeign.findById(menuId));
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu-manage";
    }
}
