package com.bindecode.binde.service;

import com.bindecode.binde.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee updateEmployee(Employee employee, Long id);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
