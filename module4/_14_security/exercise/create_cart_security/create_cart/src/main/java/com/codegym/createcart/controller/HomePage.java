package com.codegym.createcart.controller;

import com.codegym.createcart.model.Product;
import com.codegym.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String helloPage(Model model){
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "hello";
    }
}
