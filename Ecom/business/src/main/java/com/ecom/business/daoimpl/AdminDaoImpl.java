package com.ecom.business.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ecom.business.dao.AdminDao;
import com.ecom.common.vo.Admin;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;


@Repository
@Transactional
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin adminLogin(String adminUserName, String adminPassword) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Admin WHERE adminUserName = :adminUserName AND adminPassword = :adminPassword ");
		query.setParameter("adminUserName", adminUserName);
		query.setParameter("adminPassword", adminPassword);
		Admin admin = (Admin) query.uniqueResult();
		if(admin==null) {
			
		}
		return admin;
	}

	@Override
	public PrimaryAccount getBuActId(long accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM PrimaryAccount WHERE accountNumber =:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		PrimaryAccount pact = (PrimaryAccount) query.uniqueResult();
		return pact;
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.flush();
		
	}


//	@Override
//	public List<PrimaryTransaction> getTransList(long accountNumber) {
//		PrimaryAccount pa = getBuActId(accountNumber);
//		List<PrimaryTransaction> ptList = pa.getPrimaryTransactionList();
//		return ptList;
//	}
	
	

}
