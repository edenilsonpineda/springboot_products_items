package com.example.sprngboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprngboot.app.item.model.Item;
import com.example.sprngboot.app.item.model.services.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> list(){
		return itemService.findAll();
	}
	
	
	@GetMapping("/items/{id}/quantity/{quantity}")
	public Item detailsOfItem(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}
}
