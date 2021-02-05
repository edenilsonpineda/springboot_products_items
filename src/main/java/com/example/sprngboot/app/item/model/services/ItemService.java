package com.example.sprngboot.app.item.model.services;

import java.util.List;

import com.example.sprngboot.app.item.model.Item;

public interface ItemService {
	public List<Item> findAll();
	
	public Item findById(Long id, Integer quantity);
}
