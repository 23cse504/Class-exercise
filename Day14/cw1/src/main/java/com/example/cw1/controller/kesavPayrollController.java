package com.example.cw1.controller;

import com.example.cw1.model.kesavPayroll;
import com.example.cw1.service.DpakPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class kesavPayrollController {
    private final DpakPayrollService payrollService;

    public kesavPayrollController(DpakPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<kesavPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody kesavPayroll payroll) {
        kesavPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<kesavPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        kesavPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
