package com.raindrop.UnitSpring.Repository;

import com.raindrop.UnitSpring.Model.MysqlDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MysqlDemoRepository extends JpaRepository<MysqlDemo, Integer> {

    //自定义方法 根据方法名来创建sql语句
    //形成的SQL语句：select * from uitspring where userName = ?
    MysqlDemo findByName(String name);

    //手写查询语句
//    @Query("select new com.raindrop.UnitSpring.Model.MysqlDemo(mysql.UUID," +
//            "mysql.name,mysql.sex,mysql.birthday," +
//            "mysql.age) from MysqlDemo mysql where mysql.age < ?1")
//    List<MysqlDemo> findByLtAge(String age);

    void deleteByName(String uuid);

}
