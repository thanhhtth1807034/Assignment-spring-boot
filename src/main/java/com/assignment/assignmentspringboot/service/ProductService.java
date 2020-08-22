package com.assignment.assignmentspringboot.service;

import com.assignment.assignmentspringboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct();
    Product createProduct(Product product);
    Product updateProduct(Product product);
}
