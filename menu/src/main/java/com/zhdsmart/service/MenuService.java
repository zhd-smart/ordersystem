package com.zhdsmart.service;

import com.zhdsmart.entity.Menu;

import java.util.List;

public interface MenuService {
    //查询所有
    public List<Menu> findAll(int index,int limit);
    //查询记录条数
    public int count();
    //根据Id查询
    public Menu findById(int menuId);
    //新增
    public void save(Menu menu);
    //修改
    public void update(Menu menu);
    //删除
    public void deleteById(int menuId);
}
