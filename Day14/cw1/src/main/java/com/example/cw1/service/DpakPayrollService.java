package com.example.cw1.service;

import com.example.cw1.model.kesavPayroll;
import com.example.cw1.repository.kesavPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class DpakPayrollService {
    private final kesavPayrollRepo payrollRepo;

    public DpakPayrollService(kesavPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public kesavPayroll createPayroll(kesavPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public kesavPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
