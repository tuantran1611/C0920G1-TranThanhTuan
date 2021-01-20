package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.service.CustomerService;
import vn.codegym.case_study.service.CustomerTypeService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping(value = {"","/list"})
    public String showList(Model model){
        Iterable<Customer> customers = customerService.findAll();
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("customers",customers);
        model.addAttribute("customer", new Customer());
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public String showFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }
}
