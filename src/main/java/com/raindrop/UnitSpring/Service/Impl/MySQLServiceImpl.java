package com.raindrop.UnitSpring.Service.Impl;

import com.raindrop.UnitSpring.Model.MysqlDemo;
import com.raindrop.UnitSpring.Repository.MysqlDemoRepository;
import com.raindrop.UnitSpring.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MySQLServiceImpl implements MySQLService {

    @Autowired
    private MysqlDemoRepository repository;

    @Override
    public MysqlDemo findByName(String name) {
        return repository.findByName(name);
    }
}
