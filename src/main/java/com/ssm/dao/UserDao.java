package com.ssm.dao;

import com.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;

public interface UserDao {

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User login(String userName, String password);
}