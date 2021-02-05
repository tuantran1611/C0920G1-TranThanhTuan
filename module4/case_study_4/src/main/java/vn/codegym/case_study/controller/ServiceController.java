package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.RentTypeService;
import vn.codegym.case_study.service.ServiceService;
import vn.codegym.case_study.service.ServiceTypeService;

@Controller
@RequestMapping(value = {"/service"})
public class ServiceController {

    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping(value = {"", "/list"})
    public String showList(Model model) {
        Iterable<Service> services = serviceService.findAll();
        model.addAttribute("services", services);
        return "/service/list";
    }

    @GetMapping("/create-service")
    public String showFormCreate(Model model) {
        Iterable<ServiceType> serviceTypes = serviceTypeService.findAll();
        Iterable<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("service", new Service());
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        return "/service/create";
    }

    @PostMapping("/create-service")
    public String createService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Add new service " + service.getServiceName() + " success");
        return "redirect:/service/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        Iterable<ServiceType> serviceTypes = serviceTypeService.findAll();
        Iterable<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("service", service);
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String editService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Edit employee: " + service.getServiceName() + " successfully");
        return "redirect:/service/";
    }

    @GetMapping("/delete-service/{id}")
    public String showDelete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        serviceService.remove(id);
        return "redirect:/service/list";
    }
}
