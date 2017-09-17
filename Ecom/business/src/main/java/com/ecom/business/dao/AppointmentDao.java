package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.Appointment;

public interface AppointmentDao {
	
	public void saveAppointment(Appointment appointment);
	public Appointment findByAppointmentId(long appointmentId);
	List<Appointment> getAllAppointments(); 

}
