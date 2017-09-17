package com.ecom.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.UserDao;
import com.ecom.business.dao.productDao;
import com.ecom.common.vo.Cart;
import com.ecom.common.vo.User;
import com.ecom.service.AccountServices;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AccountServices accountServices;
	
	@Autowired
	private productDao productService;

	@Override
	public void registerUser(User user) {
		User localuser = findbyUserName(user.getUsername());
		if(localuser!=null) {
			System.out.println("User Already Exisis");
			return;
		}
		user.setEnable(true);
		user.setPrimaryAccount(accountServices.createPrimaryAct());
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		userDao.registerUser(user);
		productService.saveCart(cart);
		
		
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username, password);
	}

	@Override
	public User findbyUserName(String username) {
		return userDao.findbyUserName(username);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User betById(long userId) {
		User user = userDao.betById(userId);
		System.out.println(user.getPrimaryAccount().getAccountNumber());
		return user;
	}

}
