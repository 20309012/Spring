package com.caribu.caribuobank2.domin;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
@MappedSuperclass
public abstract   class Abstrackpersistance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence-Genarat")
    Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
