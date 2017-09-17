package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.RecipientDao;
import com.ecom.common.vo.Recipient;

@Repository
@Transactional
public class RecipientDaoImpl implements RecipientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveRecipient(Recipient recipient) {
		Session session = sessionFactory.getCurrentSession();
		session.save(recipient);
		session.flush();
		
	}

	@Override
	public List<Recipient> allRecipient() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("recip.findAll");
		List<Recipient> recipList = query.list();
		return recipList;
	}

	@Override
	public Recipient findById(long recipientId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("recip.findById");
		query.setParameter("recipientId", recipientId);
		Recipient recip = (Recipient) query.uniqueResult();
		return recip;
	}

	@Override
	public Recipient findByActNum(long recipientActNum) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("recip.findByAccountNum");
		query.setParameter("recipientActNum", recipientActNum);
		Recipient recip = (Recipient) query.uniqueResult();
		return recip;
	}
	
	

}
