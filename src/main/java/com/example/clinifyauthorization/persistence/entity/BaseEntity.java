package com.example.clinifyauthorization.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public class BaseEntity implements Serializable {
    private Integer id;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
