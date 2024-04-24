package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.kesavVillage;
import com.example.springapp.service.kesavVillageService;

@RestController
public class kesavVillageController {
    @Autowired
    private kesavVillageService ser;

    @PostMapping("/api/village")
    public ResponseEntity<kesavVillage> post(@RequestBody kesavVillage person) {
        if (ser.post(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/village/byname/{villageName}")
    public ResponseEntity<kesavVillage> getAll(@PathVariable String villageName) {
        kesavVillage li = ser.start(villageName);
        if (li!=null) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/village/bypopulation/{villagePopulation}")
    public ResponseEntity<List<kesavVillage>> getbyAge(@PathVariable int villagePopulation) {
        List<kesavVillage> li = ser.end(villagePopulation);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/village/{villageId}")
    public ResponseEntity<kesavVillage> get3(@PathVariable int villageId) {
        kesavVillage li = ser.get3(villageId);
        if (li!=null) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
