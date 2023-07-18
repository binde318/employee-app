package com.bindecode.binde.service.serviceImpl;

import com.bindecode.binde.exception.EmployeeAlreadyExistException;
import com.bindecode.binde.exception.EmployeeNotFoundException;
import com.bindecode.binde.model.Employee;
import com.bindecode.binde.repository.EmployeeRepository;
import com.bindecode.binde.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeAlreadyExists(employee.getEmail())){
            throw  new EmployeeAlreadyExistException(employee.getEmail()+ " already exists!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return employeeRepository.findById(id).map(st -> {
            st.setFirstName(employee.getFirstName());
            st.setLastName(employee.getLastName());
            st.setEmail(employee.getEmail());
            st.setDepartment(employee.getDepartment());
            return employeeRepository.save(st);
        }).orElseThrow(() -> new EmployeeNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Sorry, no student found with the Id :" +id));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)){
            throw new EmployeeAlreadyExistException("Sorry, student not found");
        }
        employeeRepository.deleteById(id);

    }
    private boolean employeeAlreadyExists(String email) {
        return employeeRepository.findByEmail(email).isPresent();
    }
    }
