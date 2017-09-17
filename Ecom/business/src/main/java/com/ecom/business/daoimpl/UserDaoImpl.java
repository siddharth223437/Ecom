package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.UserDao;
import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void registerUser(User user) {
	Session session = sessionFactory.getCurrentSession();
	session.save(user);
	session.flush();
	}

	@Override
	public User login(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User WHERE username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		//System.out.println(user.getFirstname());
		return user;
	}

	@Override
	public User findbyUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User WHERE username=:username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		//System.out.println(user.getFirstname());
		return user;
	}

	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User");
		List<User> listu = query.list();
		return listu;
	}

	@Override
	public User betById(long userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From User WHERE userId = :userId");
		query.setParameter("userId", userId);
		User user = (User) query.uniqueResult();
		return user;
	}
	
}
