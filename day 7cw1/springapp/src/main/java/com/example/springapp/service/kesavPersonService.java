package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.kesavPerson;
import com.example.springapp.repository.kesavPersonRepo;

@Service
public class kesavPersonService {
    @Autowired
    private kesavPersonRepo rep;

    public boolean post(kesavPerson person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<kesavPerson> getAll()
    {
        return rep.findAll();
    }

    public List<kesavPerson> getbyAge(int age)
    {
        return rep.findByAge(age);
    }
    
}
