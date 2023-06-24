package com.example.clinifyauthorization.persistence.entity;// default package
// Generated 16 Jun 2023, 19:10:03 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * DoctorTitle generated by hbm2java
 */
@Entity
@Table(name="doctor_title"
    ,catalog="clinify"
)
public class DoctorTitle extends BaseEntity {


     private String name;
     private Set<Doctor> doctors = new HashSet(0);

    public DoctorTitle() {
    }

	
    public DoctorTitle(String name) {
        this.name = name;
    }
    public DoctorTitle(String name, Set<Doctor> doctors) {
       this.name = name;
       this.doctors = doctors;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doctorTitle")
    public Set<Doctor> getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

}

