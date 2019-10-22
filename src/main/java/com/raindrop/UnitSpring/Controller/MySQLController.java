package com.raindrop.UnitSpring.Controller;

import com.raindrop.UnitSpring.Model.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
public class MySQLController {

    @GetMapping("test")
    public ResponseData test(){
        ResponseData data = new ResponseData();
        data.addData("test", "Hello World!");

        return data;
    }
}
