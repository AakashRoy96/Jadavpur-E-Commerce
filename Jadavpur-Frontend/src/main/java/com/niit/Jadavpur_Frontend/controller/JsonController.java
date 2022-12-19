package com.niit.Jadavpur_Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController 
{
	
	@Autowired
	ProductDAO productDAO ;
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts() {
		return productDAO.listActiveProducts();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		return productDAO.listActiveProductsByCategory(id);
	}

}