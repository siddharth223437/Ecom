package com.ecom.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.UserDao;
import com.ecom.business.dao.productDao;
import com.ecom.common.vo.Cart;
import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.Product;
import com.ecom.common.vo.User;
import com.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private productDao productDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Product getProductById(long productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public CartItem createCart(long productId) {
		User user = userDao.findbyUserName("sid");
		Cart cart = user.getCart();
		Product product = getProductById(productId);
		CartItem cartItem = new CartItem();
		cartItem.setTotalPrice(product.getProductPrice());
		cartItem.setProduct(product);
		productDao.saveCartItems(cartItem);
		double totalPrice = 0;
		List<CartItem> cartItemList = productDao.viewCart();
		for(CartItem c : cartItemList) {
		   totalPrice = totalPrice + c.getTotalPrice();
		   cart.setGrandTotal(totalPrice);
		}
		 cartItem.setCart(cart);
		 productDao.saveCart(cart);
		 productDao.saveCartItems(cartItem);
		return cartItem;
	}

	@Override
	public void viewTotal() {
		Cart cart = new Cart();
		double totalPrice = 0;
		List<CartItem> cartItemList = productDao.viewCart();
		for(CartItem c : cartItemList) {
		   totalPrice = totalPrice + c.getTotalPrice();
		   cart.setGrandTotal(totalPrice);
		}
		productDao.saveCart(cart);
	}

}
