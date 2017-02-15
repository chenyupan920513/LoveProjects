package com.ssm.dao;

import com.ssm.pojo.User;

public interface UserDao {

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User login(String userName, String password);
}