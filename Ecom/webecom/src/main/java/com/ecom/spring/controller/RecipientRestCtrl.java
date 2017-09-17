package com.ecom.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.business.dao.UserDao;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.Recipient;
import com.ecom.common.vo.TransRecipWrapper;
import com.ecom.common.vo.User;
import com.ecom.service.RecipientService;

@RestController
public class RecipientRestCtrl {
	
	@Autowired
	private RecipientService recipientService;
	
	@Autowired 
	private UserDao userDao;
	
	@PostMapping("/user/saverecipient")
	public ResponseEntity<Recipient> saveReipient(@RequestBody Recipient recipient,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		String myName = (String) session.getAttribute("username");
		//String myName = "sid";
		if(myName!=null) {
			recipientService.createRecipient(recipient, myName);
			return new ResponseEntity<Recipient>(recipient, HttpStatus.OK);
		}
		
		return new ResponseEntity<Recipient>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/user/recipientlist")
	public List<Recipient> allRecipient(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		String myName = (String) session.getAttribute("username");
		List<Recipient> listR = recipientService.allRecipient(myName);
		return listR;
	}
	@PostMapping("/user/transfer")
	public void transferToRecip(@RequestBody TransRecipWrapper transw){
		
		
		recipientService.depositToRecipient("sid", transw.getPrimaryTransaction().getAmount(), transw.getRecipient().getRecipientActNum(), transw.getPrimaryTransaction().getType());
		//return new ResponseEntity<Recipient>(HttpStatus.OK);
	}
	

}
