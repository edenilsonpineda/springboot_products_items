package com.example.sprngboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "products-service")
@EnableFeignClients
@SpringBootApplication
public class SpringbootProductsItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProductsItemsApplication.class, args);
	}

}
