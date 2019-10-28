package com.raindrop.UnitSpring.Controller;

import com.raindrop.UnitSpring.Model.MysqlDemo;
import com.raindrop.UnitSpring.Model.ResponseData;
import com.raindrop.UnitSpring.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mysql")
public class MySQLController {
    @Autowired
    private MySQLService service;

    @GetMapping("/find")
    public ResponseData test(){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World!");
        data.addData("return", service.findByName("111"));
        return data;
    }

    @GetMapping("/add")
    public ResponseData add(){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World");
        MysqlDemo mysqlDemo = new MysqlDemo();
        mysqlDemo.setUUID(UUID.randomUUID().toString());
        mysqlDemo.setName("张三");
        mysqlDemo.setAge("17");
        mysqlDemo.setSex("男");
        mysqlDemo.setBirthday("2019-10-25");
        service.save(mysqlDemo);
        data.addData("operation", "add");
        return data;
    }

    @GetMapping("/delete")
    public ResponseData delete(String uuid){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World");
        service.deleteByUuid(uuid);
        data.addData("operation", "delete");
        return data;
    }

    @GetMapping("/update")
    public ResponseData update(@RequestBody MysqlDemo mysqlDemo){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World");
        service.save(mysqlDemo);
        data.addData("operation", "update");
        return data;
    }
}
