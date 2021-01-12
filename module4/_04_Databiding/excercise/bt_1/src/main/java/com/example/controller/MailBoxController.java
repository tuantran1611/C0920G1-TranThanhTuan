package com.example.controller;

import com.example.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/setting")
public class MailBoxController {

    @GetMapping(value = {"","/show"})
    public String showForm(Model model){
        List<String> languageList  = new ArrayList<>();
        List<Integer> pageSizeList  = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("mailbox",new MailBox());
        return "mailbox/form";
    }

    @PostMapping("/show")
    public String showInfo(Model model , @ModelAttribute MailBox mailbox){
        return "mailbox/info";
    }
}
