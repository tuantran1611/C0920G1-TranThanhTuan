package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ModelAttribute("employees")
    public Iterable<Employee> listEmployee( @PageableDefault(value = 5) Pageable pageable){return employeeService.findAll(pageable);}

    @ModelAttribute("employee")
    public Employee employee(){return new Employee();}

    @GetMapping(value = {"","/list"})
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "employee/list";
    }

//    @GetMapping("/create-employee")
//    public String showFormCreate(Model model) {
//        Iterable<Position> positions = positionService.findAll();
//        Iterable<Division> divisions = divisionService.findAll();
//        Iterable<EducationDegree> educationDegrees = educationDegreeService.findAll();
//        Iterable<Role> roles = roleService.findAll();
//
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("positions", positions);
//        model.addAttribute("divisions", divisions);
//        model.addAttribute("educationDegrees", educationDegrees);
//        model.addAttribute("roles", roles);
//        return "/employee/create";
//    }

    @PostMapping("/create-employee")
    public String createEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
        if (bindingResult.hasErrors()){
            Iterable<Position> positions = positionService.findAll();
            Iterable<Division> divisions = divisionService.findAll();
            Iterable<EducationDegree> educationDegrees = educationDegreeService.findAll();
            Iterable<Role> roles = roleService.findAll();
            model.addAttribute( "positions", positions);
            model.addAttribute("divisions", divisions);
            model.addAttribute("educationDegrees", educationDegrees);
            model.addAttribute("roles", roles);
            model.addAttribute("employees",this.employeeService.findAll(pageable));
            model.addAttribute("check",false);
            return "/employee/list";
        } else {
            employee.getUser().setPassword(new BCryptPasswordEncoder().encode("12345"));
            employee.getUser().setEnabled(true);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Add new employee " + employee.getEmployeeName() + " success");
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Employee employee = employeeService.findById(id);
        Iterable<Position> positions = positionService.findAll();
        Iterable<Division> divisions = divisionService.findAll();
        Iterable<EducationDegree> educationDegrees = educationDegreeService.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("positions", positions);
        model.addAttribute("divisions", divisions);
        model.addAttribute("educationDegrees", educationDegrees);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
            Iterable<Position> positions = positionService.findAll();
            Iterable<Division> divisions = divisionService.findAll();
            Iterable<EducationDegree> educationDegrees = educationDegreeService.findAll();
            model.addAttribute("employee", employee);
            model.addAttribute("positions", positions);
            model.addAttribute("divisions", divisions);
            model.addAttribute("educationDegrees", educationDegrees);
            return "/employee/edit";
        } else {
            employee.getUser().setEnabled(true);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Edit employee: " + employee.getEmployeeName() + " successfully");
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable String id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/view";
    }

    @GetMapping("/view-info/{name}")
    public String viewDetailEmployee(@PathVariable String name, Model model) {

        User user = userService.findByUsername(name);
        Employee employee = employeeService.findByUser_id(user.getId());
        model.addAttribute("employee", employee);
        return "employee/view";
    }

    @GetMapping("/delete-employee/{id}")
    public String showCreate(@PathVariable String id) {
        employeeService.remove(id);
        return "redirect:/employee/list";
    }
}
