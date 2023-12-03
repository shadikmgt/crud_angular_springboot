package com.crud.angularAndSpringboot.controller;

import com.crud.angularAndSpringboot.model.Employee;
import com.crud.angularAndSpringboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping("saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }




}
