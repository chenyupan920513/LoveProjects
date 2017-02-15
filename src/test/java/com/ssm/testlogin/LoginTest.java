package com.ssm.testlogin;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.pojo.User;
import com.ssm.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class LoginTest {

	private static Logger logger = Logger.getLogger(LoginTest.class);

	@Resource
	private LoginService loginService = null;

	@Test
	public void loginTest() {
		String userName = "chenyupan";
		String password = "chenyupan";
		User user=loginService.getUser(userName, password);
		if(user!=null)
		logger.info(user.toString());
	}

}
