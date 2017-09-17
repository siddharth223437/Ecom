package com.ecom.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.vo.Appointment;
import com.ecom.service.AppointmentService;


@RestController
public class AppointmentRestCtrl {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping("/createappointment")
	public ResponseEntity<Appointment> createApp(@RequestBody Appointment appointment,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(false);
		 String myName=(String)session.getAttribute("username");
		if(myName!=null) {
			 appointment = appointmentService.createAppointment(appointment, myName);
			 return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
		 }
		 
		 return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	}

}
