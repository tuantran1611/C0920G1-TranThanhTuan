package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

//    @GetMapping(value = {"","/"})
//    public List<Employee> listEmployee() {
//        return employeeService.findAll();
//    }

    @GetMapping(value = {"","/"} ,  params = {"page", "size", "nameSorting"})
    public ResponseEntity<Page<Employee>> listEmployee(@RequestParam("page") int page, @RequestParam("size") int size,
                                                       @RequestParam("nameSorting") boolean nameSorting) {
        if (!nameSorting){
            Pageable requestedPage = PageRequest.of(page, size);
            Page<Employee> employees;
            employees = employeeService.findAll(requestedPage);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            Pageable requestedPage = PageRequest.of(page, size, Sort.by("lastName"));
            Page<Employee> employees;
            employees = employeeService.findAll(requestedPage);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/",  params = {"size", "name"})
    public ResponseEntity<Page<Employee>> listEmployeeByName(
                                                       @RequestParam("name") String name , @RequestParam("size") int size) {
            Pageable requestedPage = PageRequest.of(0, size);
            Page<Employee> employees;
            System.out.println(name);
            employees = employeeService.findAllByName(requestedPage, name);
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.findById(employeeId);
        employee.setEmail(employeeDetails.getEmail());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        employeeService.remove(employeeId);
    }
    
}
