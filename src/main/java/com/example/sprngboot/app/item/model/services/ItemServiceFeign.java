package com.example.sprngboot.app.item.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.sprngboot.app.item.clients.ProductRestClient;
import com.example.sprngboot.app.item.model.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductRestClient feignClient;

	@Override
	public List<Item> findAll() {
		return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(feignClient.detailOfProduct(id), quantity);
	}

}
