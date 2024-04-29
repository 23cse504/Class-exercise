package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.kesavStudentDetail;
import com.example.springapp.repository.kesavStudentDetailRepository;
import com.example.springapp.repository.kesavStudentRepository;

@Service
public class kesavStudentDetailService {
    @Autowired
    kesavStudentDetailRepository studentDetailRepository;
    @Autowired
    kesavStudentRepository studentRepository;
    public kesavStudentDetail addStudentDetail(int id,kesavStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}
