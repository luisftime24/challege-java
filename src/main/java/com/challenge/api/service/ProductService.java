package com.challenge.api.service;

import com.challenge.api.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);
}
