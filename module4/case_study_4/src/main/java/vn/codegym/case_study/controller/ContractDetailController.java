package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.AttachServiceService;
import vn.codegym.case_study.service.ContractDetailService;
import vn.codegym.case_study.service.ContractService;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping(value = {"","/list"})
    public String showList(Model model){
        Iterable<ContractDetail> contractDetails = contractDetailService.findAll();
        model.addAttribute("contractDetails",contractDetails);
        return "/contractDetail/list";
    }

    @GetMapping("/create-contract-detail")
    public String showFormCreate(Model model){
        Iterable<Contract> contracts = contractService.findAll();
        Iterable<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contracts",contracts);
        model.addAttribute("attachServices",attachServices);
        return "/contractDetail/create";
    }

    @PostMapping("/create-contract-detail")
    public String createContract(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","Add new contract detail success");
        return "redirect:/contract-detail/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        ContractDetail contractDetail = contractDetailService.findById(id);
        Iterable<Contract> contracts = contractService.findAll();
        Iterable<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("contractDetail",contractDetail);
        model.addAttribute("contracts",contracts);
        model.addAttribute("attachServices",attachServices);
        return "/contractDetail/edit";
    }

    @PostMapping("/edit")
    public String editContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","Edit contract detail successfully");
        return "redirect:/contract-detail/";
    }

    @GetMapping("/delete-contract-detail/{id}")
    public String showDelete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        contractDetailService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete contract detail successfully");
        return "redirect:/contract-detail/";
    }

    @GetMapping("/list-attach-service")
    public String showListAttachService(Model model){
        Iterable<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("attachServices",attachServices);
        return "/contractDetail/listAttachService";
    }
}
