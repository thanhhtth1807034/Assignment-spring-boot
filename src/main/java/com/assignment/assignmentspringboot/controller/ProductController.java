package com.assignment.assignmentspringboot.controller;

import com.assignment.assignmentspringboot.model.Product;
import com.assignment.assignmentspringboot.repository.ProductRepository;
import com.assignment.assignmentspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/list")
    public String getAllProduct (Model model){
        model.addAttribute("productList", productService.getAllProduct());
        return "list-product";
    }

    @GetMapping("/addProduct")
    public String showAddProduct(Model model){
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/addProduct")
    public String addProduct (@ModelAttribute Product product){
        return Optional.ofNullable(productService.createProduct(product))
                .map(t -> "redirect:/list")
                .orElse("failed");
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("product", product);
        return "update-product";
    }

//    @PostMapping("/update/{id}")
//    public String updateProduct( @RequestBody Product product, Model model) {
//        productService.updateProduct(product);
//        model.addAttribute("product", productRepository.findAll());
//        return "redirect:/list";
//    }
@PostMapping("update/{id}")
public String updateStudent(@PathVariable("id") Integer id,  Product product, BindingResult result,
                            Model model) {
    if (result.hasErrors()) {
        product.setId(id);
        return "update-product";
    }

    productRepository.save(product);
    model.addAttribute("product", productRepository.findAll());
    return "redirect:/list";
}

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        productRepository.delete(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/list";
    }
}
