package com.example.dummyjson.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import com.example.dummyjson.feign.ProductClient;

@Service
public class ProductService {
    
    @Autowired
    private ProductClient productClient;

    /**
     * Returns all products.
     *
     * @return The list of products found
     */
    public List<Product> getAllProducts() {
    	ProductResponse productResponse = productClient.getProducts();
        Product[] products = productResponse.getProducts();
        return Arrays.asList(products);
    }

    /**
     * Returns a product by ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return The found product
     */
    public Product getProductById(Long id) {
        return productClient.getProductById(id);
    }
}
