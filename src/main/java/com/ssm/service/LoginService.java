package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class LoginService {

	@Resource
	private UserDao userDao;

	private static final Logger logger = LogManager.getLogger(LoginService.class.getName());

	public User getUser(String userName, String password) {
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password))
			return null;
		return userDao.login(userName, password);
	}

	/**
	 * 判断用户是否存在
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean isExist(String userName, String password) {
		boolean flag = true;
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password))
			flag = false;
			password = com.ssm.utils.StringUtils.toMD5(password);
		User user = userDao.login(userName, password);
		if (user != null)
			flag = true;
		return flag;
	}

}
