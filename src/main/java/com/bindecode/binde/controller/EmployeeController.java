package com.bindecode.binde.controller;

import com.bindecode.binde.model.Employee;
import com.bindecode.binde.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
@GetMapping("/get_employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.NOT_FOUND);
    }
@PostMapping("/create_employee")
    public Employee addEmployee(@RequestBody Employee employee){
    return employeeService.addEmployee(employee);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.updateEmployee(employee, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
}
