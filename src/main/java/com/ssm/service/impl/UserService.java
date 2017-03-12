package com.ssm.service.impl;


import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService implements IUserService {


	@Autowired
	private UserDao userDao;

	public User getUserById(String userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	public int addUser(User user) {
		return this.userDao.insert(user);
	}

}