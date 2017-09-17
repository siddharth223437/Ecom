package com.ecom.business.dao;

import com.ecom.common.vo.Admin;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.User;

public interface AdminDao {
	
	public Admin adminLogin(String adminUserName,String adminPassword);
	
	public PrimaryAccount getBuActId(long accountNumber);
	
	public void updateUser(User user);
	
	//public List<PrimaryTransaction> getTransList(long accountNumber);

}
