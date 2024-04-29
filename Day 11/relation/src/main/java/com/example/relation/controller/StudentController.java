package com.example.relation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.kesavStudent;
import com.example.relation.service.kesavStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class StudentController {
    public kesavStudentService studentService;
    public StudentController(kesavStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/student")
    public kesavStudent postMethodName(@RequestBody kesavStudent student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/api/student")
    public List<kesavStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}
