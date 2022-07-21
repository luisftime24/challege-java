package com.challenge.api.controller;

import com.challenge.api.entity.Image;
import com.challenge.api.entity.Product;
import com.challenge.api.externalService.ImageService;
import com.challenge.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        Image image = imageService.getPhoto(id);
        product.addImage(image);
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/photos/{id}")
    public Object getCountries(@PathVariable("id") Long id) {
        return imageService.getPhoto(id);
    }
}
