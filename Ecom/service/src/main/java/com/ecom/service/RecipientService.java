package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.Recipient;

public interface RecipientService {
	
	public void createRecipient(Recipient recipient,String username);
	public List<Recipient> allRecipient(String username);
	public Recipient findById(long recipientId);
	public void depositToRecipient(String username,double amount,long actNum,String actType);

}
