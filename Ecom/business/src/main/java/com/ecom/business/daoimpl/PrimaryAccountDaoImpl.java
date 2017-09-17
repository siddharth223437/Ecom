package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.PrimaryAccountDao;
import com.ecom.common.vo.PrimaryAccount;
import com.ecom.common.vo.PrimaryTransaction;

@Repository
@Transactional
public class PrimaryAccountDaoImpl implements PrimaryAccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void savePrimaryAct(PrimaryAccount primaryAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(primaryAccount);
		session.flush();
		
	}



	@Override
	public void savePrimaryTransaction(PrimaryTransaction pt) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pt);
		session.flush();
		
	}

}
