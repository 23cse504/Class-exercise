package com.example.ce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ce1.model.kesavAddress;

import jakarta.transaction.Transactional;
@Repository
public interface kesavAddressRepo extends JpaRepository<kesavAddress,Integer>{

    @Modifying
    @Transactional
    @Query(value="insert into address(city,street,employee_id) values(?1,?2,?3)",nativeQuery = true)
    void setByemployeeId(String city,String street,int id);
     
}
