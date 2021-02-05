package com.codegym.createcart.controller;

import com.codegym.createcart.model.Cart;
import com.codegym.createcart.model.Product;
import com.codegym.createcart.model.Role;
import com.codegym.createcart.model.User;
import com.codegym.createcart.service.ProductService;
import com.codegym.createcart.service.RoleService;
import com.codegym.createcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;


@Controller
@RequestMapping("/product")
@SessionAttributes("carts")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute("carts")
    public HashMap<Long, Cart> getShowInfo(){
        return new HashMap<>();
    }

    @GetMapping(value = {"","/list"})
    public String showList(Model model){
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create-product")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create-product")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "New product created successfully");
        return "redirect:/product/list";
    }

    @GetMapping("/view-product/{id}")
    public String viewProduct(@PathVariable Long id, Model model, @ModelAttribute("carts") HashMap<Long, Cart> cartHashMap){
        Product product = productService.findById(id);
        model.addAttribute("carts", cartHashMap);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/delete-product/{id}")
    public String showDeleteProduct(@PathVariable Long id, Model model){
        Product product = productService.findById(id);

        model.addAttribute("product",product);
        return "delete";
    }

    @PostMapping("/delete-product/{id}")
    public String deleteProduct(@ModelAttribute Product product, @PathVariable Long id){
        productService.remove(id);
        return "redirect:/product/list";
    }

    @GetMapping("/register")
    public String showFormRegister(Model model){
        Iterable<Role> roles = roleService.findAll();
        model.addAttribute("user",new User());
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        user.setEnabled(true);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","Register successfully");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/login")
    public String checkLogin(@ModelAttribute User user,RedirectAttributes redirectAttributes){
        Iterable<User> users = userService.findAll();
        String pass = new BCryptPasswordEncoder().encode(user.getPassword());
        for (User u : users){
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(pass)){
                return "list";
            }
        }
        redirectAttributes.addFlashAttribute("message","Username or password is not correct, please input again");
        return "redirect:/login";
    }
}
