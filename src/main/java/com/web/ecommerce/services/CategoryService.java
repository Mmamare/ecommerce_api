package com.web.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.web.ecommerce.entity.Category;

public interface CategoryService {
	public List<Category> listCategories();
	public void createCategory(Category category);
	public Category readCategoryByName(String categoryName);
	public Optional<Category> readCategory(Integer categoryId);
	public void updateCategory(Integer categoryID, Category newCategory);
}
