package com.example.cw1.controller;

import com.example.cw1.model.kesavEmployee;
import com.example.cw1.service.DpakEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class kesavEmployeeController {
    private final DpakEmployeeService employeeService;

    public kesavEmployeeController(DpakEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<kesavEmployee> createEmployee(@RequestBody kesavEmployee employee) {
        kesavEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<kesavEmployee>> getAllEmployees() {
        List<kesavEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<kesavEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<kesavEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

