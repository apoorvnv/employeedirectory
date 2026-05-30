package com.example.employeedirectory.service;

import com.example.employeedirectory.entity.Employee;
import com.example.employeedirectory.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Employee Not Found") );

        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setDepartment(employee.getDepartment());
        employeeToUpdate.setJoiningDate(employee.getJoiningDate());
        employeeToUpdate.setDesignation(employee.getDesignation());
        employeeToUpdate.setSalary(employee.getSalary());

        return employeeRepository.save(employeeToUpdate);
    }
}
