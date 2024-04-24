package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.kesavPerson;
import java.util.List;


@Repository
public interface kesavPersonRepo extends JpaRepository<kesavPerson,Integer>{

    List<kesavPerson> findByNameStartingWith(String name);
    List<kesavPerson> findByNameEndingWith(String name);
    
}
