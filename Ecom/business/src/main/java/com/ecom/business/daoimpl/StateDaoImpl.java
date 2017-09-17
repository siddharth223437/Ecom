package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.StateDao;
import com.ecom.common.vo.City;
import com.ecom.common.vo.State;

@Transactional
@Repository
public class StateDaoImpl implements StateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveState(State state) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(state);
		session.flush();
		
	}

	@Override
	public void saveCity(City city) {
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(city);
		session.flush();
		
	}

	@Override
	public List<State> allCities(String stateName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From State where stateName=:stateName");
		query.setParameter("stateName", stateName);
		List<State> city = query.list();
		for(State s : city) {
			System.out.println(s.getCity());
		}
		return city;
	}

	@Override
	public State findByState(String stateName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From State where stateName=:stateName");
		query.setParameter("stateName", stateName);
		State s = (State) query.uniqueResult();
		return s;
	}

}
