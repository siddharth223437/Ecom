package com.ecom.service;

import java.util.List;

import com.ecom.common.vo.Cart;
import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.Product;

public interface ProductService {
	public Product getProductById(long productId);
	public List<Product> getAllProduct();
	public CartItem createCart(long productId);
	public void viewTotal();

}
