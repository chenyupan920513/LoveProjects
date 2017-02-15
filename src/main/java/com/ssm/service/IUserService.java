package com.ssm.service;

import com.ssm.pojo.User;

public interface IUserService {

	public User getUserById(String userId);

	public int addUser(User user);
}
