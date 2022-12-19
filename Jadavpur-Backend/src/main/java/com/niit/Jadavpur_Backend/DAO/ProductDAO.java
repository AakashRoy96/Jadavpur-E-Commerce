package com.niit.Jadavpur_Backend.DAO;

import java.util.List;

import com.niit.Jadavpur_Backend.modal.Product;

public interface ProductDAO 
{
	boolean insert(Product product);
	Product getProduct(int p_id);
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);

}