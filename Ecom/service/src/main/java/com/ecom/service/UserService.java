package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.User;

public interface UserService {
	public void registerUser(User user);
	public User login(String username,String password);
	public User findbyUserName(String username);
	public List<User> findAll();
	public User betById(long userId);

}
