package com.zhdsmart.serviceImpl;

import com.zhdsmart.dao.TypeDao;
import com.zhdsmart.entity.Type;
import com.zhdsmart.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type findById(int tId) {
        return typeDao.findById(tId);
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
