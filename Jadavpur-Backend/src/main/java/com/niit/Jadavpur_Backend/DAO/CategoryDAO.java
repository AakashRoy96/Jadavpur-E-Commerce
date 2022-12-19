package com.niit.Jadavpur_Backend.DAO;

import java.util.List;

import com.niit.Jadavpur_Backend.modal.Category;

public interface CategoryDAO 
{
	public boolean insert(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category getCategory(int id);
	public List<Category> categoryList();

}