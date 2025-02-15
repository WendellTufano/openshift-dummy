package com.example.dummyjson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import com.example.dummyjson.feign.ProductClient;


@SpringBootTest
class ProductServiceTest {
	
	@MockBean
    private ProductClient productClient;

    @Autowired
    private ProductService productService;
    
    @Test
    void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");

        Product[] products = {product1, product2};
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(products);
        when(productClient.getProducts()).thenReturn(productResponse);
        
        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");

        when(productClient.getProductById(1L)).thenReturn(product);
        
        Product result = productService.getProductById(1L);
        assertEquals("Product 1", result.getTitle());
    }
    
   
}
