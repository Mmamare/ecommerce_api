package com.web.ecommerce.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ecommerce.dto.ItemDto;
import com.web.ecommerce.entity.Category;
import com.web.ecommerce.entity.Items;
import com.web.ecommerce.repository.ItemsRepo;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	ItemsRepo itemsRepo;

	@Override
	public Items getItemsFromDto(ItemDto itemsDto, Category categor) {
		Items items = new Items();
		items.setCategory(categor);
		items.setId(itemsDto.getId());
		items.setDescription(itemsDto.getDescription());
		items.setImageURL(itemsDto.getImageURL());
		items.setName(itemsDto.getName());
		items.setPrice(itemsDto.getPrice());
		
		return items;
	}

	public ItemDto getItemsDto(Items items) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(items.getId());
		itemDto.setName(items.getName());
		itemDto.setDescription(items.getDescription());
		itemDto.setCategoryId(items.getCategory().getId());
		itemDto.setImageURL(items.getImageURL());
		itemDto.setPrice(items.getPrice());
		
		return itemDto;
	}
	@Override
	public void addItem(ItemDto itemsDto, Category category) {
		Items items = getItemsFromDto(itemsDto, category);
		itemsRepo.save(items);
		
	}

	@Override
	public List<ItemDto> getAllItems() {
		List<Items> items = itemsRepo.findAll();
		List<ItemDto> itemsDto = new ArrayList<>();
		
		for(Items item : items) {
			itemsDto.add(getItemsDto(item));
		}
		
		return itemsDto;
	}

}
