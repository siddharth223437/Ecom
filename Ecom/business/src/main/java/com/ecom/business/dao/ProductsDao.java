package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.Products;

public interface ProductsDao {
	
	public List<Products> getAllProducts();
	public Products getProductById(int pid);

}
