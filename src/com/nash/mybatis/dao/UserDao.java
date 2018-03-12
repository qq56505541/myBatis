package com.nash.mybatis.dao;

import java.util.List;

import com.nash.mybatis.model.User;

public interface UserDao {
	
	public List<User> selectUserAll() throws Exception;
	
	public void insertUser(User user) throws Exception;
}
