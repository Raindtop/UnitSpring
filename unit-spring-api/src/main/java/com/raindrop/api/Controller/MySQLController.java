package com.raindrop.api.Controller;

import com.raindrop.core.Model.MysqlDemo;
import com.raindrop.core.Model.ResponseData;
import com.raindrop.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/mysql")
public class MySQLController {
    @Autowired
    private MySQLService service;

    @GetMapping("/find")
    @PreAuthorize("hasRole('mysql')")
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
        mysqlDemo.setUuid(UUID.randomUUID().toString());
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

    @GetMapping("hello")
    public ResponseData hello(){
        return new ResponseData().addData("text", "Hello");
    }

    @GetMapping("name")
    public ResponseData name(){
        return new ResponseData().addData("text", "Joke");
    }

    @GetMapping("age")
    public ResponseData age(){
        return new ResponseData().addData("text", "18");
    }

}
