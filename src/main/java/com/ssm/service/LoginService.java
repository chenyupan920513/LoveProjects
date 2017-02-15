package com.ssm.service;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;

@Service
public class LoginService {

	@Resource
	private UserDao userDao;

	private Logger logger = Logger.getLogger(LoginService.class);

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
		try {
			password = com.ssm.utils.StringUtils.toMD5(password);
		} catch (NoSuchAlgorithmException e) {
			logger.error("Md5加密失败" + e.getMessage());
			flag = false;
		}
		User user = userDao.login(userName, password);
		if (user != null)
			flag = true;
		return flag;
	}

}
