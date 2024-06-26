package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.kesavEmployee;
import com.example.ce1.service.kesavEmployeeService;

@RestController
public class kesavEmployeeController {
    @Autowired
    kesavEmployeeService employeeService;

    @PostMapping("/employee")
    public kesavEmployee setMethod(@RequestBody kesavEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<kesavEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<kesavEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
