package com.home.personal.springdemo.service;

import com.home.personal.springdemo.model.Employee;
import com.home.personal.springdemo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public com.home.personal.springdemo.entity.Employee saveEmployee(Employee employee) {
        com.home.personal.springdemo.entity.Employee employeeObject = modelMapper.map(employee, com.home.personal.springdemo.entity.Employee.class);
        return employeeRepository.save(employeeObject);
    }

    public ResponseEntity<Employee> getEmployeeById(Long empId) {
        Optional<com.home.personal.springdemo.entity.Employee> optionalEmployee = employeeRepository.findById(empId);
        com.home.personal.springdemo.entity.Employee employeeEntity = optionalEmployee.orElse(new com.home.personal.springdemo.entity.Employee());
        return ResponseEntity.ok(modelMapper.map(employeeEntity, Employee.class));
    }
}
