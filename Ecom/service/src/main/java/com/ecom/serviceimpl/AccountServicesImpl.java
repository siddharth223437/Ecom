package com.ecom.serviceimpl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.PrimaryAccountDao;
import com.ecom.business.dao.UserDao;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;
import com.ecom.service.AccountServices;

@Service
public class AccountServicesImpl implements AccountServices {
	
	private static long nextActNum = 1234;
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void savePrimaryAct(PrimaryAccount primaryAccount) {
		primaryAccountDao.savePrimaryAct(primaryAccount);
		
	}

	@Override
	public PrimaryAccount createPrimaryAct() {
		PrimaryAccount pact = new PrimaryAccount();
		pact.setAccountBalance(BigDecimal.valueOf(0.0));
		pact.setAccountNumber(setActNum());
		savePrimaryAct(pact);
		return pact;
	}
	
	private long setActNum() {
		return ++nextActNum;
	}

	@Override
	public List<PrimaryTransaction> primaryTransactionLidt(String username) {
		User user = userDao.findbyUserName(username);
		List<PrimaryTransaction> list = user.getPrimaryAccount().getPrimaryTransactionList();
		Collections.reverse(list);
		return list;
	}

	@Override
	public void deposi(String accountType, double amount, String username) {
		User user = userDao.findbyUserName(username);
		if(accountType.equalsIgnoreCase("Primary")) {
			PrimaryAccount pact = user.getPrimaryAccount();
			pact.setAccountBalance(pact.getAccountBalance().add(BigDecimal.valueOf(amount)));
			primaryAccountDao.savePrimaryAct(pact);
			Date date = new Date();
			
			PrimaryTransaction ptrac = new PrimaryTransaction();
			ptrac.setDate(date);
			ptrac.setAmount(amount);
			ptrac.setDescription("Deposited to primary");
			ptrac.setAvailableBalance(pact.getAccountBalance());
			ptrac.setStatus("Finished");
			ptrac.setType(accountType);
			ptrac.setPrimaryAccount(pact);
			primaryAccountDao.savePrimaryTransaction(ptrac);
		}
		
	}

}
