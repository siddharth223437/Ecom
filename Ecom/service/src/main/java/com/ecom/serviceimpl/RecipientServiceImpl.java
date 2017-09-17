package com.ecom.serviceimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.PrimaryAccountDao;
import com.ecom.business.dao.RecipientDao;
import com.ecom.business.dao.UserDao;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.Recipient;
import com.ecom.common.vo.User;
import com.ecom.service.RecipientService;

@Service
public class RecipientServiceImpl implements RecipientService {
	
	@Autowired
	private RecipientDao recipientDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;

	@Override
	public void createRecipient(Recipient recipient,String username) {
		User user = userDao.findbyUserName(username);
		recipient.setUser(user);
	    recipientDao.saveRecipient(recipient);
	}

	@Override
	public List<Recipient> allRecipient(String username) {
		User user = userDao.findbyUserName(username);
		List<Recipient> recipList = user.getRecipient();
		return recipList;
	}

	@Override
	public Recipient findById(long recipientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositToRecipient(String username, double amount, long actNum,String actType) {
		User user = userDao.findbyUserName(username);
		Recipient recip = recipientDao.findByActNum(actNum);
		if(recip!=null) {
			PrimaryAccount pact = user.getPrimaryAccount();
			pact.setAccountBalance(pact.getAccountBalance().subtract(BigDecimal.valueOf(amount)));
			primaryAccountDao.savePrimaryAct(pact);
		
					
			Date date = new Date();
			PrimaryTransaction ptrac = new PrimaryTransaction();
			
			ptrac.setDate(date);
			ptrac.setAmount(amount);
			ptrac.setDescription("Transfered to"+" "+recip.getRecipientName());
			ptrac.setAvailableBalance(pact.getAccountBalance());
			ptrac.setStatus("Transfered");
			ptrac.setType(actType);
			ptrac.setPrimaryAccount(pact);
			primaryAccountDao.savePrimaryTransaction(ptrac);
				
		}
		
	}

	

}
