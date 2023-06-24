package com.example.clinifyauthorization.persistence.entity;// default package
// Generated 16 Jun 2023, 19:10:03 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Area generated by hbm2java
 */
@Entity
@Table(name="area"
    ,catalog="clinify"
)
public class Area extends BaseEntity {


     private City city;
     private String name;
     private Set<Clinic> clinics = new HashSet(0);
     private Set<Patient> patients = new HashSet(0);

    public Area() {
    }

	
    public Area(City city, String name) {
        this.city = city;
        this.name = name;
    }
    public Area(City city, String name, Set<Clinic> clinics, Set<Patient> patients) {
       this.city = city;
       this.name = name;
       this.clinics = clinics;
       this.patients = patients;
    }


@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set<Clinic> getClinics() {
        return this.clinics;
    }
    
    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
    public Set<Patient> getPatients() {
        return this.patients;
    }
    
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }




}

