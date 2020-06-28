package com.zhdsmart.service;

import com.zhdsmart.entity.Type;

import java.util.List;

public interface TypeService {

    public Type findById(int tId);

    public List<Type> findAll();
}
