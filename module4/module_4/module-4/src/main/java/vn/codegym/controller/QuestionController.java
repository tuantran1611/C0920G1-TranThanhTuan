package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Question;
import vn.codegym.model.QuestionType;
import vn.codegym.model.User;
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
    public String showList(Model model, Pageable pageable){
        model.addAttribute("questions", questionService.findAll());
        model.addAttribute("questionTypes", questionTypeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/questions/list";
    }

    @PostMapping("/create-question")
    public String createEmployee(@Validated @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
//        new Question().validate(contract,bindingResult);
        if (bindingResult.hasErrors()) {
            Iterable<Question> questions = questionService.findAll();
            model.addAttribute("questions", questions);
            model.addAttribute("check", false);
            return "/questions/list";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Add new question success");
            return "redirect:/question/list";
        }

    }
    @GetMapping("/view/{id}")
    public String viewContract(@PathVariable int id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "/questions/view";
    }

    @GetMapping("/delete-question/{id}")
    public String showCreate(@PathVariable int id) {
        questionService.remove(id);
        return "redirect:/question/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        Question question = questionService.findById(id);
        Iterable<Question> questions = questionService.findAll();
        Iterable<QuestionType> questionTypes = questionTypeService.findAll();
        Iterable<User> users = userService.findAll();
        model.addAttribute("questions", questions);
        model.addAttribute("questionTypes", questionTypes);
        model.addAttribute("users", users);
        model.addAttribute("question", question);
        return "/questions/edit";
    }

    @PostMapping("/edit")
    public String editQuestion(@Validated @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        new Question().validate(contract,bindingResult);
        if (bindingResult.hasErrors()) {
            Iterable<Question> questions = questionService.findAll();
            Iterable<QuestionType> questionTypes = questionTypeService.findAll();
            Iterable<User> users = userService.findAll();
            model.addAttribute("questions", questions);
            model.addAttribute("questionTypes", questionTypes);
            model.addAttribute("users", users);
            model.addAttribute("question", question);
            return "/questions/edit";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Edit question success");
            return "redirect:/question/list";
        }
    }

    @GetMapping("/search-title")
    public ModelAndView searchByText(@RequestParam String inputSearch){
        return new ModelAndView("/questions/list", "questions", questionService.findByTitle(inputSearch));
    }

}
