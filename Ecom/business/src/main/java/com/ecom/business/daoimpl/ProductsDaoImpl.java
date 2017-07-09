package com.ecom.business.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.business.dao.ProductsDao;
import com.ecom.common.vo.Products;

@Repository
@Transactional
public class ProductsDaoImpl implements ProductsDao {
	
	static final Logger logger = Logger.getLogger(ProductsDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Products> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		logger.info("Getting into product list query");
		Query query = session.createQuery("From Products");
		List<Products> prodList = query.list();
		logger.info("Product List size is"+" "+prodList.size());
		return prodList;
	}

}
