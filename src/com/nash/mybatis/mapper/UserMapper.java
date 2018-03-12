package com.nash.mybatis.mapper;

import java.util.List;

import com.nash.mybatis.model.User;

public interface UserMapper {
	
	/**
	* @Title: insertUser
	* @Description: 新增用户
	* @param user
	*/
	public void insertUser(User user);
	
	/**
	* @Title: updateUser
	* @Description: 通过id修改用户
	* @param user
	* @param id
	*/
	public void updateUser(User user , int id);
	
	/**
	* @Title: deleteUser
	* @Description: 删除用户
	* @param id
	*/
	public void deleteUser(int id);
	
	/**
	* @Title: selectUserById
	* @Description: 查找用户
	* @param id
	* @return
	*/
	public User selectUserById(int id);
	
	/**
	* @Title: selectUserAll
	* @Description: 查找所有用户
	* @return
	*/
	public List<User> selectUserAll();
	
	/**
	* @Title: selectUserByName
	* @Description: 用username模糊查找
	* @return
	*/
	public List<User> selectUserByName(String username);
}
