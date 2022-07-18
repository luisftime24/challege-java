package com.challenge.api.service;

import com.challenge.api.advice.TrackExecutionTime;
import com.challenge.api.entity.Product;
import com.challenge.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @TrackExecutionTime
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @TrackExecutionTime
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RuntimeException("Product is not found for the id " + id);
    }

    @TrackExecutionTime
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @TrackExecutionTime
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName() != null ? product.getName() : existingProduct.getName());
        existingProduct.setDescription(product.getDescription() != null ? product.getDescription() : existingProduct.getDescription());
        existingProduct.setPrice(product.getPrice() != 0 ? product.getPrice() : existingProduct.getPrice());
        existingProduct.setCategory(product.getCategory() != null ? product.getCategory() : existingProduct.getCategory());
        return productRepository.save(existingProduct);
    }
}
