package com.example.day6cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day6cw1.model.kesavChildren;


@Repository
public interface kesavChildrenRepo extends JpaRepository<kesavChildren,Integer>{
    
}
