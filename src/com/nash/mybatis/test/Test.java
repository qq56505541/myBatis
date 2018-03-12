package com.nash.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.nash.mybatis.mapper.UserMapper;
import com.nash.mybatis.model.User;



public class Test {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public void connect(){
		String url = "mybatis.cfg.xml";
		
		InputStream input = null;
		
		//得到配置文件流
		try{
			input = Resources.getResourceAsStream(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			
			
	}
	
	@org.junit.Test
	public void selectData(){
		connect();
		
		SqlSession session = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成UserMapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
//		List<User> list = userMapper.selectUserAll();
		
		List<User> list = userMapper.selectUserByName("nas");
		
		for(User user : list){
			System.out.println(user.getId() + " " + user.getUsername() + " " + user.getSex());
		}
		
		session.close();
	}
	
	@org.junit.Test
	public void insertData(){
		//得到sqlSessionFactory
		connect();
		
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		
		
		
		user.setUsername("nash");
		
		user.setPassword("123");
		
		user.setSex("男");
		
		try{
			
			userMapper.insertUser(user);
			session.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}
		
		System.out.println(user.getId());
		session.close();
		
	}
}
