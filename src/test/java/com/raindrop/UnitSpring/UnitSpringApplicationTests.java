package com.raindrop.UnitSpring;

import com.raindrop.UnitSpring.Model.MysqlDemo;
import com.raindrop.UnitSpring.Service.MySQLService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitSpringApplication.class)
@WebAppConfiguration
public class UnitSpringApplicationTests {
	@Autowired
	private MySQLService sqlService;

	@Test
	public void contextLoads() {
		System.out.print("1111");
	}

	@Test
	public void save(){
		MysqlDemo mysqlDemo = new MysqlDemo();
		mysqlDemo.setName("王五");
		mysqlDemo.setAge("17");
		mysqlDemo.setSex("男");
		mysqlDemo.setBirthday("2019-10-25");

		sqlService.save(mysqlDemo);
	}

	@Test
	public void delete(){
		sqlService.deleteByUuid("3be369c0-022e-4f32-98fe-2bc90318d803");
	}

	@Test
	public void update(){
		MysqlDemo mysqlDemo = new MysqlDemo();
		mysqlDemo.setName("王五的儿子");
		mysqlDemo.setAge("18");
		mysqlDemo.setSex("男");
		mysqlDemo.setBirthday("2019-10-25");
		mysqlDemo.setUuid("402881f66e10170e016e10171cd10000");
		sqlService.update(mysqlDemo);
	}
}
