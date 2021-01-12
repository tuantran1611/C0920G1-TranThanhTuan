package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @GetMapping()
    public String showForm(){
        return "index";
    }

    @PostMapping("calculate")
    public String calculator(@RequestParam("calculate") String calculate, @RequestParam int number1, @RequestParam int number2 , RedirectAttributes redirectAttributes){
        int result = 0;
        switch (calculate){
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1 * number2;
                break;
            case "Division":
                result = number1 / number2;
                break;
        }
        redirectAttributes.addFlashAttribute("result", "Result " + calculate + " : " + result);
        return "redirect:/";
    }
}
