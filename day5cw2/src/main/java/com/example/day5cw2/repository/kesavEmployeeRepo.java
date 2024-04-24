package com.example.day5cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5cw2.model.kesavEmployee;


@Repository
public interface kesavEmployeeRepo extends JpaRepository<kesavEmployee,Integer>{
    
}
