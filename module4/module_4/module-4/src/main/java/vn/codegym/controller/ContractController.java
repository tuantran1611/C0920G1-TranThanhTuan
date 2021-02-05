//package vn.codegym.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import vn.codegym.model.Contract;
//import vn.codegym.model.Customer;
//import vn.codegym.service.ContractService;
//import vn.codegym.service.CustomerService;
//
//import java.util.Date;
//
//@Controller
//@RequestMapping("/contract")
//public class ContractController {
//
//    @Autowired
//    ContractService contractService;
//    @Autowired
//    CustomerService customerService;
//
//    @ModelAttribute("contracts")
//    public Iterable<Contract> listContract(){ return contractService.findAll();}
//    @ModelAttribute("contract")
//    public Contract contract(){return new Contract();}
//
//    @GetMapping(value = {"","/list"})
//    public String showList(Model model){
//        model.addAttribute("contracts", this.contractService.findAll());
//        model.addAttribute("customers", customerService.findAll());
//        return "/contract/list";
//    }
//
//    @PostMapping("/create-contract")
//    public String createEmployee(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
//        new Contract().validate(contract,bindingResult);
//        if (bindingResult.hasErrors()) {
//            Iterable<Customer> customers = customerService.findAll();
//            model.addAttribute("customers", customers);
//            model.addAttribute("check", false);
//            return "/contract/list";
//        } else {
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("message", "Add new contract success");
//            return "redirect:/contract/list";
//        }
//
//    }
//    @GetMapping("/view/{id}")
//    public String viewContract(@PathVariable String id, Model model) {
//        Contract contract = contractService.findById(id);
//        model.addAttribute("contract", contract);
//        return "/contract/view";
//    }
//
//    @GetMapping("/delete-contract/{id}")
//    public String showCreate(@PathVariable String id) {
//        contractService.remove(id);
//        return "redirect:/contract/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showFormEdit(@PathVariable String id, Model model) {
//        Contract contract = contractService.findById(id);
//        Iterable<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        model.addAttribute("contract", contract);
//        return "/contract/edit";
//    }
//
//    @PostMapping("/edit")
//    public String editCustomer(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        new Contract().validate(contract,bindingResult);
//        if (bindingResult.hasErrors()) {
//            Iterable<Customer> customers = customerService.findAll();
//            model.addAttribute("customers", customers);
//            return "/contract/edit";
//        } else {
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("message", "Edit contract success");
//            return "redirect:/contract/list";
//        }
//    }
//
//    @GetMapping("/search")
//    public ModelAndView searchByText(@RequestParam String inputSearch){
//        return new ModelAndView("/contract/list", "contracts", contractService.findByCustomer_NameCusContainingOrIdContractContaining(inputSearch, inputSearch));
//    }
//
//}
