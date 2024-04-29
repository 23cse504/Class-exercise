package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.kesavDoor;
import com.examly.springapp.repository.kesavDoorRepo;

@Service
public class kesavDoorService {
    @Autowired
    private kesavDoorRepo doorRepo;

    public kesavDoor postData(kesavDoor door) {
        return doorRepo.save(door);
    }

    public List<kesavDoor> getBycolor(String color) {
        return doorRepo.findByColor(color);
    }

    public kesavDoor updateDetail(int doorid, kesavDoor door) {
        return doorRepo.save(door);
    }

    public boolean deleteDoor(int doorid) {
        doorRepo.deleteById(doorid);
        return true;
    }

    public List<kesavDoor> getByDoorType(String doortype) {
        return doorRepo.findByDoorType(doortype);
    }

    public List<kesavDoor> getAllDetails() {

        return doorRepo.findAll();
    }

    public kesavDoor getDetailsById(int doorid) {
        return doorRepo.findById(doorid).orElse(null);
    }

}