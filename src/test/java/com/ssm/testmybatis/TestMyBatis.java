package com.ssm.testmybatis;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.SEX;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import com.ssm.utils.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;

	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test() {
		User user = userService.getUserById("1");
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setBirthday(new Date());
			user.setPassword(StringUtils.toMD5("chenyupan"));
		user.setPhone("18817573489");
		user.setSex(SEX.女);
		user.createKey();
		user.setUserName("陈宇潘");
		int i = userService.addUser(user);
			
	}
}