package com.ecom.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;
import com.ecom.service.AccountServices;
import com.ecom.service.UserService;

@RestController
public class AccountRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountServices accountServices;
	
	@GetMapping("/primary")
	public ResponseEntity<PrimaryAccount> getAccountDetails(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(false);
		 String myName=(String)session.getAttribute("username");
		 if(myName!=null) {
			 User user = userService.findbyUserName(myName);
			 PrimaryAccount pact = user.getPrimaryAccount();
			 return new ResponseEntity<PrimaryAccount>(pact,HttpStatus.OK);
		 }
		 return new ResponseEntity<PrimaryAccount>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/primarytransactionlist")
	public List<PrimaryTransaction> getPrimaryTransactionList(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(false);
		 String myName=(String)session.getAttribute("username");
		 if(myName!=null) {
			 System.out.println(myName);
		 }
		 List<PrimaryTransaction> pTransac = accountServices.primaryTransactionLidt(myName);
		 return pTransac;
	}
	
	@PostMapping("/deposit")
	public ResponseEntity<PrimaryTransaction> depositAmount(@RequestBody PrimaryTransaction pt,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession(false);
		 String myName=(String)session.getAttribute("username");
		 if(myName!=null) {
		    accountServices.deposi(pt.getType(), pt.getAmount(), myName);
		    return new ResponseEntity<PrimaryTransaction>(pt,HttpStatus.OK);
		 }
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
