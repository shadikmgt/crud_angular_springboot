package com.crud.angularAndSpringboot.service;

import com.crud.angularAndSpringboot.exception.ResourceNotFoundException;
import com.crud.angularAndSpringboot.model.Employee;
import com.crud.angularAndSpringboot.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee>getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exist wit this id : " + id));
    }

    public Employee updateEmployee(int id, Employee employee){
        Employee existEmployee = repository.findById(id).orElse(null);
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName((employee.getLastName()));
        existEmployee.setEmailId(employee.getEmailId());
        return repository.save(existEmployee);
//        Employee employeeDetails =  repository.findById(id)
//                .orElseThrow(
//                        () -> new ResourceNotFoundException("Employee not exist wit this id : " + id));
//        employeeDetails.setFirstName(employee.getFirstName());
//        employeeDetails.setLastName(employee.getLastName());
//        employeeDetails.setEmailId(employee.getEmailId());
//        return repository.save(employee);
    }

//    public ResponseEntity<Map<String, Boolean>> deleteEmployee(int id){
//        Employee employee = repository.findById(id).orElse(null);
//        repository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
    public void deleteEmployee(int id){
        repository.deleteById(id);
    }


}
