package com.crud.angularAndSpringboot.service;

import com.crud.angularAndSpringboot.model.Employee;
import com.crud.angularAndSpringboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
