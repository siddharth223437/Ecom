package com.ecom.serviceimpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.AdminDao;
import com.ecom.common.vo.Admin;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;
import com.ecom.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin adminLogin(String adminUserName, String adminPassword) {
		return adminDao.adminLogin(adminUserName, adminPassword);
	}

	@Override
	public PrimaryAccount getBuActId(long accountNumber) {
		PrimaryTransaction pt = new PrimaryTransaction();
		PrimaryAccount pa = pt.getPrimaryAccount();
		pa = adminDao.getBuActId(accountNumber);
		return pa;
		//return adminDao.getBuActId(accountNumber);
	}

	@Override
	public List<PrimaryTransaction> getTransList(long accountNumber) {
		PrimaryAccount pa = getBuActId(accountNumber);
		List<PrimaryTransaction> ptList = pa.getPrimaryTransactionList();
		Collections.reverse(ptList);
		for(PrimaryTransaction p : ptList) {
			System.out.println(p.getDate());
		}
		return ptList;
	}

	@Override
	public void updateUser(User user) {
		PrimaryAccount pa = new PrimaryAccount();
		pa.setAccountNumber(user.getPrimaryAccount().getAccountNumber());
		pa.setAccountBalance(user.getPrimaryAccount().getAccountBalance());
		pa.setPrimaryId(user.getPrimaryAccount().getPrimaryId());
		user.setPrimaryAccount(pa);
		adminDao.updateUser(user);

	}



}
