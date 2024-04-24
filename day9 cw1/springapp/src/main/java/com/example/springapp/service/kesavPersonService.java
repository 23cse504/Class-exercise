package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.kesavPerson;
import com.example.springapp.repository.kesavPersonRepo;

@Service
public class kesavPersonService {
    public kesavPersonRepo personRepo;

    public kesavPersonService(kesavPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(kesavPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<kesavPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}
