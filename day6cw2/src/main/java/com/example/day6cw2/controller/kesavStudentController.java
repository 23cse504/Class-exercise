package com.example.day6cw2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw2.model.kesavStudent;
import com.example.day6cw2.service.kesavStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class kesavStudentController {
    public kesavStudentService studentService;
    public kesavStudentController(kesavStudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/api/student")
    public ResponseEntity<kesavStudent> postMethodName(@RequestBody kesavStudent student) {
        if(studentService.postStudent(student))
        {
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/student")
    public ResponseEntity<List<kesavStudent>> getMethodName(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size) {
        List<kesavStudent> list = studentService.paginationStudents(pageno,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    
    @GetMapping("/api/student/sort")
    public ResponseEntity<List<kesavStudent>> getsortPagination(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size,@RequestParam("sortBy") String field) {
        List<kesavStudent> list = studentService.sortPaginationStudents(pageno, size, field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    
}
