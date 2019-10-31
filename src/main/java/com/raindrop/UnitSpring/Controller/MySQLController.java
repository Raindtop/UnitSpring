package com.raindrop.UnitSpring.Controller;

import com.raindrop.UnitSpring.Model.MysqlDemo;
import com.raindrop.UnitSpring.Model.ResponseData;
import com.raindrop.UnitSpring.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

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

    //for循环
//    public static void main(String[] args) {
//        String[] strs = {"3333", "2222", "1111"};
//        List<String> list = Arrays.asList(strs);
//        list = new ArrayList<>(list);
//        for (int i = 0; i < list.size(); i++){
//            String str = list.get(i);
//            if (i == 2){
//                list.remove(str);
//                continue;
//            }
//            System.out.println(str);
//        }
//    }
    //foreach循环
//    public static void main(String[] args) {
//        String[] strs = {"3333", "2222", "1111"};
//        List<String> list = Arrays.asList(strs);
//        list = new ArrayList<>(list);
//        for (String str: list){
//            if (str.equals("1111")){
//                list.remove(str);
//                continue;
//            }
//            System.out.println(str);
//        }
//    }

    //for循环鱼foreach效率对比
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++){
            list.add(i);
        }


        long startTime=System.currentTimeMillis();   //获取开始时间
        for (int i = 0; i < list.size(); i++){
            //不输出数据，程序运行时间太短
            System.out.println(list.get(i));
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        long fortime = endTime - startTime;

        startTime=System.currentTimeMillis();   //获取开始时间
        for (int i : list){
            //不输出数据，程序运行时间太短
            System.out.println(i);
        }
        endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("for运行时间： "+fortime+"ms");
        System.out.println("foreach运行时间： "+(endTime - startTime)+"ms");
    }
}
