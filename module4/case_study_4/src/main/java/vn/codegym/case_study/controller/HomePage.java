package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.model.User;
import vn.codegym.case_study.service.UserService;

@Controller
public class HomePage {
    @Autowired
    UserService userService;
    @GetMapping(value = {"/"})
    public String showHello(){
        return "home";
    }

//    @GetMapping("/login/success")
//    public String loginSuccess(){
//        return "home";
//    }

    @GetMapping("/login")
    public String showLogin(){
//        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping("/403")
    public String showException(){
        return "403";
    }
//    @PostMapping("/login")
//    public String checkLogin(@ModelAttribute User user, RedirectAttributes redirectAttributes){
//        Iterable<User> users = userService.findAll();
//        String pass = new BCryptPasswordEncoder().encode(user.getPassword());
//        for (User u : users){
//            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(pass)){
//                return "home";
//            }
//        }
//        redirectAttributes.addFlashAttribute("message","Username or password is not correct, please input again");
//        return "redirect:/login";
//    }
}
