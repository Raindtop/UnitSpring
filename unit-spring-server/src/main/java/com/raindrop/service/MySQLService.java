package com.raindrop.service;


import com.raindrop.core.Model.MysqlDemo;

public interface MySQLService {
    /**
     * 通过名称获取对象
     * @param name
     * @return
     */
    public MysqlDemo findByName(String name);

    /**
     * 插入对象，基于DataJPA的已有的接口
     */
    public void save(MysqlDemo mysqlDemo);

    /**
     * 根据主键删除
     * @param uuid
     */
    public void deleteByUuid(String uuid);

    /**
     * 更新数据
     */
    public void update(MysqlDemo mysqlDemo);

}
