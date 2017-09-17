package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;

public interface PrimaryAccountDao {
	
	public void savePrimaryAct(PrimaryAccount primaryAccount);
	
	public void savePrimaryTransaction(PrimaryTransaction pt);

}
