package com.crud.angularAndSpringboot.controller;

import com.crud.angularAndSpringboot.model.Employee;
import com.crud.angularAndSpringboot.repository.EmployeeRepository;
import com.crud.angularAndSpringboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeService service,EmployeeRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee exisanceEmployee = service.updateEmployee(id, employee);
        return ResponseEntity.ok(exisanceEmployee);
    }

//        @PutMapping("/updateEmployee/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
//        Employee employee = repository.findById(id).orElse(null);
//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setEmailId(employeeDetails.getEmailId());
//
//        Employee updateEmployee = repository.save(employee);
//        return ResponseEntity.ok(updateEmployee);
//    }
//


//    @DeleteMapping("deleteEmployee/{id}")
//    public ResponseEntity<Map<String, Boolean>>deleteEmployee(@PathVariable int id){
//        service.deleteEmployee(id);
//        return ResponseEntity.ok()
//    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
    }

}
