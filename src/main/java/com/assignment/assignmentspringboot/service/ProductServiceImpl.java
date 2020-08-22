package com.assignment.assignmentspringboot.service;

import com.assignment.assignmentspringboot.model.Product;
import com.assignment.assignmentspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> prod = productRepository.findById(product.getId());
        if (!prod.isPresent()){
            return null;
        }
        Product p = prod.get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
//        p.setCategoryid(product.getCategoryid());
        return productRepository.save(p);
    }
}
