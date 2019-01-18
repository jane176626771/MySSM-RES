package com.farsight.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farsight.dao.UserDao;
import com.farsight.entity.User;
import com.farsight.service.UserService;

@Service
@Transactional//此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao dao;

	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public User findById(int id) {
		
		return dao.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
