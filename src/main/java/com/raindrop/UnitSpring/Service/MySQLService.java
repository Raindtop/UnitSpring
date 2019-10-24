package com.raindrop.UnitSpring.Service;

import com.raindrop.UnitSpring.Model.MysqlDemo;

public interface MySQLService {
    public MysqlDemo findByName(String name);
}
