//package com.ecom.spring.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.ecom.common.vo.CustomerLogin;
//import com.ecom.common.vo.PrimaryAccount;
//import com.ecom.common.vo.PrimaryTransaction;
//import com.ecom.service.PrimaryAccountService;
//
//@Controller
//public class PrimaryAccountController {
//	
//	@Autowired
//	private PrimaryAccountService primaryAccountService;
//	
//	@GetMapping("/customers/pa")
//	public String primAct(Model model,HttpServletRequest request, HttpServletResponse response) {
//		PrimaryAccount primaryAccount = new PrimaryAccount();
//		 HttpSession session=request.getSession(false);
//		 String myName=(String)session.getAttribute("username");
//		 if(myName!=null) {
//			 primaryAccount = primaryAccountService.primayActHome(myName);
//			 model.addAttribute("primaryAct", primaryAccount);
//		 }
//		 System.out.println("d");
//		 return "primaryaccount";
//	}
//	
//	@GetMapping("/customers/deposit")
//	public String deposit(Model model,HttpServletRequest request, HttpServletResponse response) {
//		PrimaryTransaction pa = new PrimaryTransaction();
//		model.addAttribute("deposit", pa);
//		//model.addAttribute("amount", "");
//		return "deposit";
//	}
//	
//	@PostMapping("/customers/deposit")
//	public String postDeposit(@ModelAttribute("deposit") PrimaryTransaction pt,HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session=request.getSession(false);
//		 String myName=(String)session.getAttribute("username");
//		 if(myName!=null) {
//			 primaryAccountService.addDeposit(pt.getType(), pt.getAmount(), myName);
//		 }
//		 return "redirect:/customers/pa";
//	}
//}
