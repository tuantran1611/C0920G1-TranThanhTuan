package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {

    @GetMapping()
    public String showForm(){
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam( required = false, name = "condiment") String[] condiments , RedirectAttributes redirectAttributes){
        StringBuilder sandwich;
        if (condiments != null) {
            sandwich = new StringBuilder("Sandwich with condiments: ");
            for (String s : condiments) {
                sandwich.append(s).append(" ");
            }
        } else {
            sandwich = new StringBuilder("Sandwich with not condiments");
        }
        redirectAttributes.addFlashAttribute("sandwich",sandwich);
        return "redirect:/";
    }
}
