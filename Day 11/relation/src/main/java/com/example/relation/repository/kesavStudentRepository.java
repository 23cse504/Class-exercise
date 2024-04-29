package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.kesavStudent;

@Repository
public interface kesavStudentRepository extends JpaRepository<kesavStudent,Integer>{
    
}
