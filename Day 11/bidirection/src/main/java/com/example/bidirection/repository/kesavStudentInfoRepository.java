package com.example.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirection.model.kesavStudentInfo;

@Repository
public interface kesavStudentInfoRepository extends JpaRepository<kesavStudentInfo,Integer>{
    
}