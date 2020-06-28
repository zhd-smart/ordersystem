package com.zhdsmart.controller;

import com.zhdsmart.entity.Type;
import com.zhdsmart.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping(value = "/findById/{tId}")
    public Type findById(@PathVariable("tId") int tId){
        return typeService.findById(tId);
    }

    @GetMapping(value = "/findAll")
    public List<Type> findAll(){
        return typeService.findAll();
    }
}
