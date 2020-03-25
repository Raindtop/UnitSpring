package com.raindrop.api.Controller;

import com.raindrop.LoggerAndException.ExceptionAno;
import com.raindrop.Model.MysqlDemo;
import com.raindrop.Model.ResponseData;
import com.raindrop.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tim")
public class ExceptionAOPController {
    @Autowired
    private MySQLService service;

    @GetMapping("/test")
    @ExceptionAno
    public ResponseData aopException()throws Exception{
        ResponseData responseData = new ResponseData();
        System.out.println("故事内容");
        System.out.println("故事内容");
        System.out.println("故事内容");
        //抛出异常
        throw new Exception();
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
}
