package com.example.cw1.service;

import com.example.cw1.model.kesavEmployee;
import com.example.cw1.repository.kesavEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DpakEmployeeService {
    private final kesavEmployeeRepo employeeRepo;

    public DpakEmployeeService(kesavEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public kesavEmployee createEmployee(kesavEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<kesavEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<kesavEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
