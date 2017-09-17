package com.ecom.common.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue
	public long userid;
	@Size(max = 20, min = 3, message = "{user.name.empty}")
	public String username;
	public String firstname;
	public String lastname;
	@Size(max = 20, min = 3, message = "{user.password.empty}")
	public String password;
	public boolean enable;
	@OneToOne(cascade=CascadeType.ALL)
	private PrimaryAccount primaryAccount;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Appointment> appointmentList;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Recipient> recipient;
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}
	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Recipient> getRecipient() {
		return recipient;
	}
	public void setRecipient(List<Recipient> recipient) {
		this.recipient = recipient;
	}
	
	
	

}
