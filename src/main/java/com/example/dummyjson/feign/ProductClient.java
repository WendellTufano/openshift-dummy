package com.example.dummyjson.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

@FeignClient(name = "productClient", url = "${feign.clients.product.url}")
public interface ProductClient {

	/**
     * Returns all products through the external dummyjson API.
     *
     * @param id The ID of the product to be retrieved.
     * @return The retrieved product.
     */
	@GetMapping("/products")
    ProductResponse getProducts();
	
	/**
     * Returns a product by ID from the external dummyjson API.
     *
     * @param id The ID of the product to be retrieved.
     * @return The retrieved product.
     */
	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable("id") Long id);
	
}
