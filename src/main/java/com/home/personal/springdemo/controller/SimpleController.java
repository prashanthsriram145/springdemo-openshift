package com.home.personal.springdemo.controller;

import com.home.personal.springdemo.model.Employee;
import com.home.personal.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    private final EmployeeService employeeService;

    public SimpleController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Value("${username}")
    private String username;


    @GetMapping("/welcome")
    public String getHello() {
        return String.format("Hello %s", username);
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<com.home.personal.springdemo.entity.Employee> saveEmployeeDetails(@RequestBody Employee employee) {
        try {
            com.home.personal.springdemo.entity.Employee employeeObject = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(employeeObject);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("getEmployee/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long empId) {
        return employeeService.getEmployeeById(empId);
    }
}
