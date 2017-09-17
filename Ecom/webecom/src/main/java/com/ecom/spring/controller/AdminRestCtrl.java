package com.ecom.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.vo.Admin;
import com.ecom.common.vo.Appointment;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;

import com.ecom.service.AdminService;
import com.ecom.service.AppointmentService;
import com.ecom.service.UserService;


@RestController
public class AdminRestCtrl {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin){
		if(admin!=null) {
			admin = adminService.adminLogin(admin.getAdminUserName(), admin.getAdminPassword());
			if(admin!=null) {
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/admin/user/all")
	public List<User> getAllUser(){
		System.out.println("In All List");
		List<User> user = userService.findAll();
		System.out.println(user.size());
		return user;
	}
	
	@GetMapping("/admin/act/{actnum}")
	public List<PrimaryTransaction> getTran(@PathVariable("actnum") long actnum){
		return adminService.getTransList(actnum);
	}
	@GetMapping("/admin/allappointment")
	public List<Appointment> getAllAppointment(){
	    List<Appointment> app=appointmentService.getAllAppointments();
	    return app;
	}
	@GetMapping("/admin/app/{id}")
	public ResponseEntity<Appointment> confirmApp(@PathVariable("id") long id){
		appointmentService.confirmAppointment(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/admin/edit/{id}")
	public ResponseEntity<User> getByUserId(@PathVariable("id") long id){
		User user = userService.betById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PutMapping("/admin/updateuser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		if(user!=null) {
			adminService.updateUser(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
	}

}
