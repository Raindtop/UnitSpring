package com.raindrop.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.raindrop.core.Model.MysqlDemo;
import com.raindrop.core.Repository.MysqlDemoRepository;
import com.raindrop.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MySQLServiceImpl implements MySQLService {

    @Autowired
    private MysqlDemoRepository repository;

    @Override
    public MysqlDemo findByName(String name) {
        return repository.findByName(name);
    }

    /**
     * 插入数据，save是接口中存在的方法，用于插入、修改数据
     * @param mysqlDemo
     */
    @Override
    public void save(MysqlDemo mysqlDemo) {
        repository.save(mysqlDemo);
    }

    /**
     * 根据UUID删除数据
     * @param uuid
     */
    @Override
    public void deleteByUuid(String uuid) {
        repository.deleteByUuid(uuid);
    }

    /**
     * 修改数据，同保存数据，若是对应主键数据不存在，则插入数据
     * @param mysqlDemo
     */
    @Override
    public void update(MysqlDemo mysqlDemo) {
        repository.save(mysqlDemo);
    }
}
