package com.raindrop.UnitSpring.Controller;

import com.raindrop.UnitSpring.LoggerAndException.ExceptionAno;
import com.raindrop.UnitSpring.Model.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class ExceptionAOPController {

    @RequestMapping("/test")
    @ExceptionAno
    public ResponseData aopException(){
        ResponseData responseData = new ResponseData();

        return responseData;
    }

}
