package com.assignment.assignmentspringboot.repository;

import com.assignment.assignmentspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
