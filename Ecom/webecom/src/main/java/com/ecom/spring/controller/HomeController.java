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
//import com.ecom.common.vo.CustomerDetail;
//import com.ecom.common.vo.CustomerLogin;
//import com.ecom.service.CustomerService;
//
//@Controller
//public class HomeController {
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@GetMapping("/")
//	public String home() {
//		return "redirect:/customers/addcustomer";
//	}
//	
//	@GetMapping("/customers/addcustomer")
//	public String getRegister(Model model) {
//		CustomerDetail custDetail = new CustomerDetail();
//		model.addAttribute("addCustomer", custDetail);
//		return "home";
//	}
//	
//	@PostMapping("/customers/addcustomer")
//	public String postMapping(@ModelAttribute("addCustomer") CustomerDetail custDetai) {
//		System.out.println("In Register post");
//		customerService.saveCustomer(custDetai);
//		System.out.println("DONE ADDING");
//		return "success";
//	}
//	
//	@GetMapping("/customers/login")
//	public String getLoginPage(Model model) {
//		CustomerLogin custLog = new CustomerLogin();
//		model.addAttribute("custLogin", custLog);
//		return "Login";
//	}
//	@PostMapping("/customers/login")
//	public String postLoginPage(@ModelAttribute("custLogin") CustomerLogin custLogin,HttpServletRequest request,HttpServletResponse response) {
//		customerService.customerLogin(custLogin.getUserName(), custLogin.getPassword());
//		System.out.println("");
//		HttpSession session = request.getSession(true);
//		session.setAttribute("username", custLogin.getUserName());
//	    return "redirect:/customers/pa";
//	}
//
//}
