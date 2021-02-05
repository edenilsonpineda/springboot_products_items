package com.example.sprngboot.app.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.sprngboot.app.item.model.Product;

@FeignClient(name = "products-service")
public interface ProductRestClient {
	
	@GetMapping("/products")
	public List<Product> list();
	
	@GetMapping("/products/{id}")
	public Product detailOfProduct(@PathVariable Long id);
}
