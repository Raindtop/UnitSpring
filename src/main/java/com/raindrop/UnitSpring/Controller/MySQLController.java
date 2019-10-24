package com.raindrop.UnitSpring.Controller;

import com.raindrop.UnitSpring.Model.ResponseData;
import com.raindrop.UnitSpring.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
public class MySQLController {
    @Autowired
    private MySQLService service;

    @GetMapping("test")
    public ResponseData test(){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World!");
        data.addData("return", service.findByName("111"));
        return data;
    }
}
