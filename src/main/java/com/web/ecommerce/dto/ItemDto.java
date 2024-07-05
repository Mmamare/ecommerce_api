package com.web.ecommerce.dto;

import com.web.ecommerce.entity.Items;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	private Integer id;
    private  String name;
    private  String imageURL;
    private  double price;
    private  String description;
    private  Integer categoryId;
    
    public ItemDto(Items items) {
    	//this.setId(items.getId());
    	this.setName(items.getName());
    	this.setDescription(items.getDescription());
    	this.setPrice(items.getPrice());
    	this.setImageURL(items.getImageURL());
    	this.setCategoryId(items.getCategory().getId());
    }

}
