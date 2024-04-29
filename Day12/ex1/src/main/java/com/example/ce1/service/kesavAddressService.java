package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.kesavAddress;
import com.example.ce1.repository.kesavAddressRepo;
import com.example.ce1.repository.kesavEmployeeRepo;

@Service
public class kesavAddressService {
    @Autowired
    kesavAddressRepo addressRepo;
    @Autowired
    kesavEmployeeRepo employeeRepo;
    public kesavAddress setAddressById(int id,kesavAddress address)
    {
        if(employeeRepo.existsById(id))
        {
            addressRepo.setByemployeeId(address.getCity(), address.getStreet(), id);
            return address;
        }
        else
        {
            return null;
        }
    }
}
