package com.example.day6cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw1.model.kesavChildren;
import com.example.day6cw1.service.kesavChildrenService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class kesavChildrenController {
    public kesavChildrenService childrenService;
    public kesavChildrenController(kesavChildrenService childrenService)
    {
        this.childrenService = childrenService;
    }
    @PostMapping("/api/children")
    public ResponseEntity<kesavChildren> postMethodName(@RequestBody kesavChildren children) {
        if(childrenService.postChildren(children))
        {
            return new ResponseEntity<>(children,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<kesavChildren>> getMethodName(@PathVariable("field") String field) {
        List<kesavChildren> list = childrenService.getSortedChildrens(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<kesavChildren>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<kesavChildren> list = childrenService.getPaginationChildrens(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<kesavChildren>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<kesavChildren> list = childrenService.getSortedPaginationChildrens(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}
