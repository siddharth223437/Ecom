package com.ecom.common.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="recip.findById",query="FROM Recipient Where recipientId = :recipientId"),
	@NamedQuery(name="recip.findAll",query="FROM Recipient"),
	@NamedQuery(name="recip.findByAccountNum",query="FROM Recipient Where recipientActNum = :recipientActNum")
})
public class Recipient {
	@Id
	@GeneratedValue
	private long recipientId;
	private String recipientName;
	private String recipientEmail;
	private long recipientActNum;
	private long recipientPhoneNum;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public long getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(long recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public long getRecipientActNum() {
		return recipientActNum;
	}
	public void setRecipientActNum(long recipientActNum) {
		this.recipientActNum = recipientActNum;
	}
	public long getRecipientPhoneNum() {
		return recipientPhoneNum;
	}
	public void setRecipientPhoneNum(long recipientPhoneNum) {
		this.recipientPhoneNum = recipientPhoneNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
