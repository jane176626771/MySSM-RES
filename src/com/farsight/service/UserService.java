package com.farsight.service;

import java.util.List;

import com.farsight.entity.User;

public interface UserService {
	public void addUser(User user);
	public boolean deleteUser(int id);
	public void updateUser(User user);
	public User findById(int id);
	public List<User> findAll();
}
