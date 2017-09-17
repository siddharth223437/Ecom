package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.Appointment;

public interface AppointmentService {
	
	public void saveAppointment(Appointment appointment);
	public Appointment createAppointment(Appointment appointment,String username);
	public List<Appointment> getAllAppointments();
	public Appointment findByAppointmentId(long appointmentId);
	public void confirmAppointment(long id);

}
