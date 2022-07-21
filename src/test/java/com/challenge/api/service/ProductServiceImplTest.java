package com.challenge.api.service;

import com.challenge.api.entity.Product;
import com.challenge.api.repository.ProductRepository;
import com.challenge.api.service.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        product = new Product();
        product.setId(1L);
        product.setName("Macbook");
        product.setDescription("Description of Macbook");
        product.setPrice(14999.99f);
        product.setCategory("Technology");
    }

    @Test
    void getAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productService.getAllProducts());
    }

    @Test
    void getProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));
        assertEquals(product, productService.getProductById(1L));
    }

    @Test
    void addProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        assertNotNull(productService.addProduct(new Product()));
    }

    @Test
    void updateProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        assertNotNull(productService.updateProduct(1L, new Product()));
    }
}