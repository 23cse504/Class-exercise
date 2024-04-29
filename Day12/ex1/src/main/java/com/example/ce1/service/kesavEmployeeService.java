package com.example.ce1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.kesavEmployee;
import com.example.ce1.repository.kesavEmployeeRepo;

@Service
public class kesavEmployeeService {
    @Autowired
    kesavEmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public kesavEmployee setEmployee(kesavEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<kesavEmployee> getInnerEmployee()
    {
        return employeeRepo.getByInnerEmployees();
    }

    public List<kesavEmployee> getLeftOuterEmployee()
    {
        return employeeRepo.getByLeftOuterEmployees();
    }
}
