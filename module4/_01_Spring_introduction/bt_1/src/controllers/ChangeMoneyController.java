package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @GetMapping("/changeMoney")
    public String changeMoney(@RequestParam String usa , Model model) {
        double vnd = Double.parseDouble(usa) * 23000;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usa",usa);
        return "change";
    }
}
