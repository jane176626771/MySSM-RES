package com.farsight.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.farsight.entity.User;

public interface UserDao {
	public void addUser(User user);
	public boolean deleteUser(int id);
	public void updateUser(User user);
	public User findById(int id);
	public List findAll();

}
