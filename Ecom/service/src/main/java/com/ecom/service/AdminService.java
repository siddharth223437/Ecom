package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.Admin;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;


public interface AdminService  {
	
	public Admin adminLogin(String adminUserName,String adminPassword);
	public PrimaryAccount getBuActId(long accountNumber);
	public List<PrimaryTransaction> getTransList(long accountNumber);
	public void updateUser(User user);


}
