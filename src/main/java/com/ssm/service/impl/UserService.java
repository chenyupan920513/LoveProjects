package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Resource
	private UserDao userDao;

	public User getUserById(String userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	public int addUser(User user) {
		return this.userDao.insert(user);
	}

}