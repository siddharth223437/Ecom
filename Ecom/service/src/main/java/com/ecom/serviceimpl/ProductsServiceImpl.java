package com.ecom.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.ProductsDao;
import com.ecom.common.vo.Products;
import com.ecom.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	static final Logger logger = Logger.getLogger(ProductsServiceImpl.class);
	
	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Products> getAllProducts() {
		logger.info("In Product List Service");
		return productsDao.getAllProducts();
	}

}
