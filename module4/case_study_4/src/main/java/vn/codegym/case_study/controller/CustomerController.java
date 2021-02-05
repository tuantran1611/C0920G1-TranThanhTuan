package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String showList(Model model, @PageableDefault(value = 5)Pageable pageable){
        Iterable<Customer> customers = customerService.findAll(pageable);
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypes);
        model.addAttribute("customers",customers);
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public String showFormCreate(Model model){
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypes",customerTypes);
        return "/customer/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            Iterable<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customerTypes",customerTypes);
            return "/customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message","Add new customer " + customer.getCustomerName() + " successfully");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model){
        Customer customer = customerService.findById(id);
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customer",customer);
        model.addAttribute("customerTypes",customerTypes);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated  @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){

            return "/customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit customer: " + customer.getCustomerName() + " successfully");
            return "redirect:/customer/";
        }
    }

    @GetMapping("/view/{id}")
    public String viewCustomer(@PathVariable String id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "customer/view";
    }

    @GetMapping("/delete-customer/{id}")
    public String showDelete(@PathVariable String id){
        customerService.remove(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search-customer")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("/customer/list", "customers", customerService.findByInputText(inputSearch, pageable));
    }
}
