package com.nash.mybatis.daoimpl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.nash.mybatis.dao.UserDao;
import com.nash.mybatis.model.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp(){
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
	
	@Test
	public void test() throws Exception {
		UserDao userdao = new UserDaoImpl(sqlSessionFactory);
		
		List<User> list = userdao.selectUserAll();
		
		for(User user : list){
			System.out.println(user.getId() + " " + user.getUsername() + " " + user.getSex());
		}
	}

}
