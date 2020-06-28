package com.zhdsmart.serviceImpl;

import com.zhdsmart.dao.MenuDao;
import com.zhdsmart.entity.Menu;
import com.zhdsmart.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    //查询所有
    @Override
    public List<Menu> findAll(int index,int limit) {
        return menuDao.findAll(index,limit);
    }
    //查询所有记录条数
    @Override
    public int count() {
        return menuDao.count();
    }
    //根据Id查询
    @Override
    public Menu findById(int menuId) {
        return menuDao.findById(menuId);
    }
    //新增
    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }
    //修改
    @Override
    public void update(Menu menu) {
        menuDao.update(menu);
    }
    //删除
    @Override
    public void deleteById(int menuId) {
        menuDao.deleteById(menuId);
    }
}
