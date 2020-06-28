package com.zhdsmart.dao;

import com.zhdsmart.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {

    public Type findById(int tId);

    public List<Type> findAll();
}
