package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.kesavStudent;
import com.example.springapp.repository.kesavStudentRepository;

@Service
public class kesavStudentService {
    @Autowired
    kesavStudentRepository studentRepository;
    public kesavStudent addStudents(kesavStudent student)
    {
        return studentRepository.save(student);
    }
    public List<kesavStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<kesavStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<kesavStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}
