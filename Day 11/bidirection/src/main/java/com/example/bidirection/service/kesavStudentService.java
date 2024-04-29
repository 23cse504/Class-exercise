package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.kesavStudent;
import com.example.bidirection.model.kesavStudentInfo;
import com.example.bidirection.repository.kesavStudentInfoRepository;
import com.example.bidirection.repository.kesavStudentRepository;

@Service
public class kesavStudentService {
    public kesavStudentRepository studentRepository;
    public kesavStudentInfoRepository studentInfoRepository;
    public kesavStudentService(kesavStudentRepository studentRepository,kesavStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public kesavStudent saveStudent(kesavStudent student)
    {
        return studentRepository.save(student);
    }
    public kesavStudentInfo saveStudentInfo(kesavStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<kesavStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
