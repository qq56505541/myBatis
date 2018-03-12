package com.nash.mybatis.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nash.mybatis.dao.UserDao;
import com.nash.mybatis.model.User;

public class UserDaoImpl implements UserDao {
	
	//因为没有进行对象托管，所以这里模拟注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<User> selectUserAll() throws Exception {
		//因为sqlsession线程不安全获取sqlsession，进行操作
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("com.nash.mybatis.mapper.UserMapper.selectUserAll");
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
