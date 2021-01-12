package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = {"","/list"})
    public ModelAndView show(){
        return new ModelAndView("/product/list","productList",productService.findAll());
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/edit";
    }

    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("successMsg", "Update Product " + product.getNameProduct() + " success");
        return "redirect:/product";
    }
}
