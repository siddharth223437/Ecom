package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;

public interface AccountServices {
	
	public void savePrimaryAct(PrimaryAccount primaryAccount);
	
	public PrimaryAccount createPrimaryAct();
	
	public List<PrimaryTransaction> primaryTransactionLidt(String username);
	
	public void deposi(String accountType,double amount,String username);
	
	

}
