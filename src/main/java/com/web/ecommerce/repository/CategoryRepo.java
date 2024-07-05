package com.web.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.ecommerce.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	Category findByCategoryName(String categoryName);

}
