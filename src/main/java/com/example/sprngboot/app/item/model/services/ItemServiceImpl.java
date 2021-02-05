package com.example.sprngboot.app.item.model.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.sprngboot.app.item.model.Item;
import com.example.sprngboot.app.item.model.Product;

@Service
public class ItemServiceImpl implements ItemService {
	private static final String URL = "http://localhost:8089";
	
	@Autowired
	private RestTemplate restTemplateClient;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restTemplateClient.getForObject(URL.concat("/products"), Product[].class));
		
		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Product singleProduct = restTemplateClient.getForObject(URL.concat("/products/{id}"), Product.class, pathVariables);
		return new Item(singleProduct, quantity);
	}

}
