package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.kesavPerson;
import com.example.springapp.service.kesavPersonService;

@RestController
public class kesavPersonController {
    public kesavPersonService personService;

    public kesavPersonController(kesavPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/person")
    public ResponseEntity<kesavPerson> postMethodName(@RequestBody kesavPerson person) {
        if (personService.savePerson(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/person/byage/{age}")
    public ResponseEntity<List<kesavPerson>> getMethodName(@PathVariable("age") int age) {
        List<kesavPerson> list = personService.getPersonByAge(age);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
