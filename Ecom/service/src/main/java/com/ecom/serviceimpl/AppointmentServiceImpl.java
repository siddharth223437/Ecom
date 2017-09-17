package com.ecom.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.AppointmentDao;
import com.ecom.business.dao.UserDao;
import com.ecom.common.vo.Appointment;
import com.ecom.common.vo.User;
import com.ecom.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentDao appoimtmentDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void saveAppointment(Appointment appointment) {
		appoimtmentDao.saveAppointment(appointment);
		
	}

	@Override
	public Appointment createAppointment(Appointment appointment,String username) {
		User user = userDao.findbyUserName(username);
		//appointment.setConfirmed(true);
		 appointment.setUser(user);
		 appoimtmentDao.saveAppointment(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appoimtmentDao.getAllAppointments();
	}

	@Override
	public Appointment findByAppointmentId(long appointmentId) {
		return appoimtmentDao.findByAppointmentId(appointmentId);
	}

	@Override
	public void confirmAppointment(long id) {
		Appointment app = findByAppointmentId(id);
		app.setConfirmed(true);
		appoimtmentDao.saveAppointment(app);
		
	}

}
