package com.codegym.createcart.controller;

import com.codegym.createcart.model.Cart;
import com.codegym.createcart.model.Product;
import com.codegym.createcart.service.CartService;
import com.codegym.createcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/cart")
@SessionAttributes("carts")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/buy/{id}")
    public String addCart(@PathVariable Long id, @SessionAttribute(name = "carts") HashMap<Long,Cart> cartHashMap ,  Model model){
        if (cartHashMap == null){
            cartHashMap = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product != null){
            if (cartHashMap.containsKey(id)){
                Cart item = cartHashMap.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity()+1);
                cartHashMap.put(id,item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartHashMap.put(id, item);
            }
        }
        model.addAttribute("carts",cartHashMap);
        model.addAttribute("cartNum",cartHashMap.size());
        return "cart";
    }
}
