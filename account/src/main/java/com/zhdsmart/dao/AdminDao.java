package com.zhdsmart.dao;

import com.zhdsmart.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    public Admin login(String userName,String password);
}
