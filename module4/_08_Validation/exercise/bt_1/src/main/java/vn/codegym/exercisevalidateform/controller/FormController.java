package vn.codegym.exercisevalidateform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.exercisevalidateform.model.User;

@Controller
@RequestMapping(value = "/user")
public class FormController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public ModelAndView createUser(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("user/create");
        } else {
            return new ModelAndView("user/result");}
    }
}
