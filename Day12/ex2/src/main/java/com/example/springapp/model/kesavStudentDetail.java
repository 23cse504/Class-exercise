package com.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studentDetail")
public class kesavStudentDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String address;
    String phoneNumber;
    @OneToOne(cascade=CascadeType.REMOVE ,fetch=FetchType.LAZY)
    @JoinColumn(name="student_id",referencedColumnName = "id")
    @JsonBackReference
    kesavStudent student;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public kesavStudent getStudent() {
        return student;
    }
    public void setStudent(kesavStudent student) {
        this.student = student;
    }
    
    
}
