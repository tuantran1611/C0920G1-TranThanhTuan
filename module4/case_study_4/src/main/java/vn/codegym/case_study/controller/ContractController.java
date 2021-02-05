package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.ContractService;
import vn.codegym.case_study.service.CustomerService;
import vn.codegym.case_study.service.EmployeeService;
import vn.codegym.case_study.service.ServiceService;

import java.util.function.BinaryOperator;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    ContractService contractService;

    @GetMapping(value = {"","/list"})
    public String showList(Model model){
        Iterable<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts",contracts);
        return "/contract/list";
    }

    @GetMapping("/create-contract")
    public String showFormCreate(Model model){
        Iterable<Customer> customers = customerService.findAll();
        Iterable<Employee> employees = employeeService.findAll();
        Iterable<Service> services = serviceService.findAll();
        model.addAttribute("contract",new Contract());
        model.addAttribute("customers",customers);
        model.addAttribute("employees",employees);
        model.addAttribute("services",services);
        return "/contract/create";
    }

    @PostMapping("/create-contract")
    public String createContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            Iterable<Customer> customers = customerService.findAll();
            Iterable<Employee> employees = employeeService.findAll();
            Iterable<Service> services = serviceService.findAll();
            model.addAttribute("customers",customers);
            model.addAttribute("employees",employees);
            model.addAttribute("services",services);
            return "/contract/create";
        } else {
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Add new contract success");
            return "redirect:/contract/";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        Contract contract = contractService.findById(id);
        Iterable<Customer> customers = customerService.findAll();
        Iterable<Employee> employees = employeeService.findAll();
        Iterable<Service> services = serviceService.findAll();
        model.addAttribute("contract",contract);
        model.addAttribute("customers",customers);
        model.addAttribute("employees",employees);
        model.addAttribute("services",services);
        return "/contract/edit";
    }

    @PostMapping("/edit")
    public String editContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            Iterable<Customer> customers = customerService.findAll();
            Iterable<Employee> employees = employeeService.findAll();
            Iterable<Service> services = serviceService.findAll();
            model.addAttribute("customers",customers);
            model.addAttribute("employees",employees);
            model.addAttribute("services",services);
            return "/contract/edit";
        } else {
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Edit contract successfully");
            return "redirect:/contract/";
        }
    }

    @GetMapping("/delete-contract/{id}")
    public String showDelete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        contractService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete contract successfully");
        return "redirect:/contract/";
    }

//    @GetMapping("/list-cus-use-service")
//    public String listCusUseService(){
//
//    }
}
