package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Question;
import vn.codegym.service.QuestionService;
import vn.codegym.service.QuestionTypeService;
import vn.codegym.service.UserService;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionTypeService questionTypeService;
    @Autowired
    UserService userService;

    @ModelAttribute("questions")
    public Iterable<Question> listQuestion(){ return questionService.findAll();}
    @ModelAttribute("question")
    public Question question(){return new Question();}

    @GetMapping(value = {"","/list"})
    public String showList(Model model){
        model.addAttribute("questions", this.questionService.findAll());
        model.addAttribute("questionTypes", questionTypeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/questions/list";
    }

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
}
