package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.AppointmentDao;
import com.ecom.common.vo.Appointment;

@Repository
@Transactional
public class AppointmentDaoImpl implements AppointmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		Session session = sessionFactory.getCurrentSession();
	     session.saveOrUpdate(appointment);
		session.flush();
	}

	@Override
	public Appointment findByAppointmentId(long appointmentId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Appointment where appointmentId = :appointmentId");
		query.setParameter("appointmentId", appointmentId);
		Appointment appointment = (Appointment) query.uniqueResult();
		return appointment;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Appointment");
		List<Appointment> appList = query.list();
		return appList;
	}
	
	

}
