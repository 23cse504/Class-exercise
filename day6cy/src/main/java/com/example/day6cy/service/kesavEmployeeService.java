package com.example.day6cy.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cy.model.kesavEmployee;
import com.example.day6cy.repository.kesavEmployeeRepo;

@Service
public class kesavEmployeeService {
    public kesavEmployeeRepo employeeRepo;
    public kesavEmployeeService(kesavEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean postEmployee(kesavEmployee employee)
    {
        try{

            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<kesavEmployee> sortEmployee(String field)
    {
        return employeeRepo.findAll(Sort.by(field));
    }
    public List<kesavEmployee> paginationEmployee(int pageno,int size)
    {
        return employeeRepo.findAll(PageRequest.of(pageno, size)).getContent();
    }
    public List<kesavEmployee>  sortPaginationEmployee(int pageno,int size,String field)
    {
        return employeeRepo.findAll(PageRequest.of(pageno, size,Sort.by(field))).getContent();
    }
}
