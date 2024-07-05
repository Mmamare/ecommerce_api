package com.web.ecommerce.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web.ecommerce.entity.Category;
import com.web.ecommerce.services.CategoryService;


@RestController
@RequestMapping("/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("create")
	public ResponseEntity<?> createCategory(@RequestBody Category category){
		if(Objects.nonNull(categoryService.readCategoryByName(category.getCategoryName()))) {
			return new ResponseEntity("Category already exists", HttpStatus.OK);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<>("Category created", HttpStatus.CREATED);
		
	}
	
	@GetMapping("categorys")
	public ResponseEntity<List<Category>> getCategory(){
		List<Category> body = categoryService.listCategories();
		
		return new ResponseEntity<>(body, HttpStatus.OK);
		
	}
	
	@PostMapping("update/{categoryId}")
		public ResponseEntity<?> updateCategory(@PathVariable Integer categoryId, 
				@RequestBody Category category){
			if(Objects.nonNull(categoryService.readCategory(categoryId))) {
				//if the category exists update it
				categoryService.updateCategory(categoryId, category);
				return new ResponseEntity<>("Category updated", HttpStatus.OK);
			}
			
			return new ResponseEntity<>("Category doesn't exist", HttpStatus.NOT_FOUND);
			
		}
	
}
