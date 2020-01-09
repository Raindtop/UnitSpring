package com.raindrop.UnitSpring;

import com.raindrop.UnitSpring.Controller.ExceptionAOPController;
import com.raindrop.UnitSpring.LoggerAndException.ExceptionAno;
import com.raindrop.UnitSpring.Model.MysqlDemo;
import com.raindrop.UnitSpring.Service.MySQLService;
import com.raindrop.UnitSpring.Utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//此处调用Spring单元测试类
@RunWith(SpringRunner.class)
//下面这个类是你设定的启动类，也就是根目录下的Application.class
@SpringBootTest(classes = UnitSpringApplication.class)
//调用javaWEB的组件，比如自动注入ServletContext Bean等等
@WebAppConfiguration
public class UnitSpringApplicationTests {
	@Autowired
	private MySQLService sqlService;
	@Autowired
	private ExceptionAOPController exceptionAOPController;
	@Autowired
	private RedisUtil redisUtil;


	@Test
	@ExceptionAno
	public void contextLoads() {
		System.out.print("1111");
	}

	@Test
	public void RedisTest(){
		redisUtil.set("18806728288", "测试", 600);
		System.out.print(redisUtil.get("18806728288"));
	}
	@Test
	public void ExceptionTest() throws Exception {
		exceptionAOPController.aopException();
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
