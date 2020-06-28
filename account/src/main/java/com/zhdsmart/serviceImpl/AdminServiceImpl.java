package com.zhdsmart.serviceImpl;

import com.zhdsmart.dao.AdminDao;
import com.zhdsmart.entity.Admin;
import com.zhdsmart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String userName, String password) {
        return adminDao.login(userName,password);
    }
}
