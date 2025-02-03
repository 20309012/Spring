package com.caribu.caribuobank2.domin;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@SequenceGenerator(name = "sequence-generator",initialValue = 1,sequenceName = "clint-sequence")
@Table(name = "m-client")
public class Client extends Abstrackpersistance implements Serializable {
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private String middlename;
    private String mobilename;
    private String emailAdress;
    private String externalId;
    @Temporal(TemporalType.DATE)
    private Date detaOfBirth;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "office-id")
    private Office office;
    @OneToMany(mappedBy = "client")
    private List<SavingsAccunt>savingsAccuntList;

    public List<SavingsAccunt> getSavingsAccuntList() {
        return savingsAccuntList;
    }

    public void setSavingsAccuntList(List<SavingsAccunt> savingsAccuntList) {
        this.savingsAccuntList = savingsAccuntList;
    }

    public Client(Date detaOfBirth) {
        this.detaOfBirth = detaOfBirth;
    }

    public Client(String firstName, String lastName, String middlename, String mobilename, String emailAdress, String externalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middlename = middlename;
        this.mobilename = mobilename;
        this.emailAdress = emailAdress;
        this.externalId = externalId;
    }

    public Client() {

    }

    public Date getDetaOfBirth() {
        return detaOfBirth;
    }

    public void setDetaOfBirth(Date detaOfBirth) {
        this.detaOfBirth = detaOfBirth;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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

}
