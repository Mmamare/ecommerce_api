package com.web.ecommerce.services;

import java.util.List;

import com.web.ecommerce.dto.ItemDto;
import com.web.ecommerce.entity.Category;
import com.web.ecommerce.entity.Items;

public interface ItemsService {
	public Items getItemsFromDto(ItemDto itemsDto, Category categor);
	
	public void addItem(ItemDto itemsDto, Category categor);
	
	public List<ItemDto> getAllItems();
}
