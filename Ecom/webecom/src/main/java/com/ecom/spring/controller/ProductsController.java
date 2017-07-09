package com.ecom.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.common.vo.Products;
import com.ecom.service.ProductsService;

@Controller
public class ProductsController {
	
	static final Logger logger = Logger.getLogger(ProductsController.class);
	
	@Autowired
	private ProductsService productsServices;
	
	@GetMapping("/productlist")
	public String allProducts(Model model){
		List<Products> prodList = productsServices.getAllProducts();
		logger.info("roduct list controller"+" "+prodList.size());
		model.addAttribute("products", prodList);
		return "productList";
	}
	
	@GetMapping("/viewproducts/{pid}")
	public String getProductById(@PathVariable("pid") int pid, Model model,Products product) {
		logger.info("Inside get Product By Id Controller");
		product = productsServices.getProductById(pid);
		logger.info("Getting result after product by id" +" "+product.getProductCondition());
		model.addAttribute("viewProduct", product);
		return "viewProducts";
	}

}
