package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.Recipient;

public interface RecipientDao {

	public void saveRecipient(Recipient recipient);
	public List<Recipient> allRecipient();
	public Recipient findById(long recipientId);
	public Recipient findByActNum(long recipientActNum);
}
