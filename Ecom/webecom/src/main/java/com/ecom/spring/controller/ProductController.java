package com.ecom.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.vo.CartItem;
import com.ecom.common.vo.Product;
import com.ecom.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/prod/all")
	public List<Product> allProd(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/prod/{id}")
	public ResponseEntity<CartItem> getProductById(@PathVariable("id") long id){
		CartItem cartItem = productService.createCart(id);
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.OK);
	}

}
