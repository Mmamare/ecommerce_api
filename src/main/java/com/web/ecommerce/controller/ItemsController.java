package com.web.ecommerce.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.web.ecommerce.dto.ItemDto;
import com.web.ecommerce.entity.Category;
import com.web.ecommerce.services.CategoryService;
import com.web.ecommerce.services.ItemsService;

@RestController
@RequestMapping("/")
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("add")
	public ResponseEntity<?> addItems(@RequestBody ItemDto itemDto){
		Optional<Category> optionalCategory = categoryService.readCategory(itemDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			return new ResponseEntity<>("Category invalid", HttpStatus.CONFLICT);
		}
		
		Category category = optionalCategory.get();
		itemsService.addItem(itemDto, category);
		return new ResponseEntity<>(itemDto, HttpStatus.OK);
	}
	
	@GetMapping("items")
	public ResponseEntity<List<ItemDto>> listItems(){
		List<ItemDto> itemDto = itemsService.getAllItems();
		
		return new ResponseEntity<>(itemDto, HttpStatus.OK);
	}

}
