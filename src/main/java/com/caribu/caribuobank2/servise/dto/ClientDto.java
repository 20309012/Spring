package com.caribu.caribuobank2.servise.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.Date;
@Mapper
public class ClientDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String middlename;
    private String mobilename;
    private String emailAdress;
    private String externalId;
    @Temporal(TemporalType.DATE)
    private Date detaOfBirth;
    private Long officeId;

    public ClientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMobilename() {
        return mobilename;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Date getDetaOfBirth() {
        return detaOfBirth;
    }

    public void setDetaOfBirth(Date detaOfBirth) {
        this.detaOfBirth = detaOfBirth;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }
}
