package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Product;

public class ProductTest 
{

	private static AnnotationConfigApplicationContext context;
	static Product product;
	static ProductDAO productDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testInsert()
	{
		product = new Product();
		product.setId(5);
		product.setName("boAt Bassheads 100 Wired Headset");
		product.setBrand("boAt");
		product.setDescription("Connector type: 3.5\r\n" + 
				"Tangle free Cable\r\n" + 
				"Hawk Inspired Design\r\n" + 
				"Super Extra Bass\r\n" + 
				"Easy Integrated controls with Mic");
		product.setUnitPrice(399);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(2);
		product.setQuantity(4);
		
		assertEquals("Error" , true , productDAO.insert(product));
	}
	
	//@Test
	public void testGetProduct()
	{
		product = productDAO.getProduct(1);
		
		assertEquals("Error" , "PRDf311b4016544", product.getCode());
	}
	
	//@Test
	public void testActiveProduct()
	{
		assertEquals("Error" ,3, productDAO.listActiveProducts().size());
	}
	
	//@Test
	public void testActiveCategoryProduct()
	{
		assertEquals("Error" ,2, productDAO.listActiveProductsByCategory(5).size());
	}
	
	
}