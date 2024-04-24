package com.example.day6cw2.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw2.model.kesavStudent;
import com.example.day6cw2.repository.kesavStudentRepo;

@Service
public class kesavStudentService {
    public kesavStudentRepo studentRepo;
    public kesavStudentService(kesavStudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }
    public boolean postStudent(kesavStudent student)
    {
        try{

            studentRepo.save(student);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<kesavStudent> paginationStudents(int pageno,int size)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size)).getContent();
    }
    public List<kesavStudent>  sortPaginationStudents(int pageno,int size,String field)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size,Sort.by(field))).getContent();
    }
}
