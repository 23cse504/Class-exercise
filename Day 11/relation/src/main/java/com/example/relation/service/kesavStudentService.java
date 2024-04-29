package com.example.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relation.model.kesavStudent;
import com.example.relation.repository.StudentRepository;

@Service
public class kesavStudentService {
    public StudentRepository studentRepository;
    public kesavStudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public kesavStudent saveStudent(kesavStudent student)
    {
        return studentRepository.save(student);
    }
    public List<kesavStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
