package com.ecom.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecom.common.vo.Admin;
import com.ecom.common.vo.User;
import com.ecom.service.AdminService;
import com.ecom.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getHome() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String getLogin(Locale locale,Model model, User user) {
		model.addAttribute("login", user);
		return "index";
	}
	
	@PostMapping("/login")
	public String postLogin(@Valid @ModelAttribute("login") User user,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
		if(result.hasErrors()) {
			return "index";
		}
		user =userService.login(user.getUsername(), user.getPassword());
		System.out.println(user.getFirstname());
		HttpSession session = request.getSession(true);
		session.setAttribute("firstname", user.getFirstname());
		session.setAttribute("username", user.getUsername());
		System.out.println(user.getFirstname());
		System.out.println(user.getUsername());
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String getSuccess(Model model,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		 String myName=(String)session.getAttribute("username");
		 System.out.println(myName);
		 return "success";
	}

}
