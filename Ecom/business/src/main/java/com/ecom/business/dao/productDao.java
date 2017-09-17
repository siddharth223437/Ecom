package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.Cart;
import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.Product;

public interface productDao {
	
	public List<Product> getAllProduct();
	public Product getProductById(long productId);
	public void saveCartItems(CartItem cartItems);
	public List<CartItem> viewCart();
	public void saveCart(Cart cart);

}
