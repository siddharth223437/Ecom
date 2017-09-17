package com.ecom.common.vo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PrimaryAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long primaryId;
	private long accountNumber;
	private BigDecimal accountBalance;
	@OneToMany(mappedBy="primaryAccount",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<PrimaryTransaction> primaryTransactionList;
	public long getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(long primaryId) {
		this.primaryId = primaryId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<PrimaryTransaction> getPrimaryTransactionList() {
		return primaryTransactionList;
	}
	public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
		this.primaryTransactionList = primaryTransactionList;
	}
	
	

}