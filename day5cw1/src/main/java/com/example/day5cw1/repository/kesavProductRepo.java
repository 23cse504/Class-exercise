package com.example.day5cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5cw1.model.kesavProduct;

@Repository
public interface kesavProductRepo extends JpaRepository<kesavProduct,Integer>{
    
}
