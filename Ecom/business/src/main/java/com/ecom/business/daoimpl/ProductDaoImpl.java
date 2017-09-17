package com.ecom.business.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.productDao;
import com.ecom.common.vo.Cart;
import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.Product;

@Repository
@Transactional
public class ProductDaoImpl implements productDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Product");
		List<Product> allProduct = query.list();
		return allProduct;
	}

	@Override
	public Product getProductById(long productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Product where productId = :productId");
		query.setParameter("productId", productId);
		Product p = (Product) query.uniqueResult();
		return p;
	}

	@Override
	public void saveCartItems(CartItem cartItems) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItems);
		session.flush();
		
	}
	
	@Override
	public List<CartItem> viewCart() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From CartItem");
		List<CartItem> cartItems = query.list();
		return cartItems;
	}

	@Override
	public void saveCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.flush();
		
	}
	
	

}
