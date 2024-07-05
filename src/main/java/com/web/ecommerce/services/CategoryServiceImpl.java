package com.web.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ecommerce.entity.Category;
import com.web.ecommerce.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	

	@Override
	public List<Category> listCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public void createCategory(Category category) {
		categoryRepo.save(category);
		
	}

	@Override
	public Category readCategoryByName(String categoryName) {
		return categoryRepo.findByCategoryName(categoryName);
	}

	@Override
	public Optional<Category> readCategory(Integer categoryId) {
		return categoryRepo.findById(categoryId);
	}

	@Override
	public void updateCategory(Integer categoryID, Category newCategory) {
		Category category = categoryRepo.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		category.setImageUrl(newCategory.getImageUrl());
		
		categoryRepo.save(category);
		
	}
	

}
