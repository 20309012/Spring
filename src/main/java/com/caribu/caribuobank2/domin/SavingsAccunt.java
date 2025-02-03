package com.caribu.caribuobank2.domin;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Entity

public class SavingsAccunt extends Abstrackpersistance implements Serializable {
    private String accuntNumber;
    private String exterlId;
    @Enumerated(EnumType.STRING)
    private SavingsAccuntStatuseType statuse;

    private BigDecimal nominalAnnalInterestRate;

  private BigDecimal minReqequingBalance;
    @Column(name = "accontblancedriver",nullable = false)
    private BigDecimal accountBalance=BigDecimal.ZERO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client-id")
    private Client client;


    public SavingsAccunt() {
    }

    public String getAccuntNumber() {
        return accuntNumber;
    }

    public void setAccuntNumber(String accuntNumber) {
        this.accuntNumber = accuntNumber;
    }

    public String getExterlId() {
        return exterlId;
    }

    public void setExterlId(String exterlId) {
        this.exterlId = exterlId;
    }

    public SavingsAccuntStatuseType getStatuse() {
        return statuse;
    }

    public void setStatuse(SavingsAccuntStatuseType statuse) {
        this.statuse = statuse;
    }

    public BigDecimal getNominalAnnalInterestRate() {
        return nominalAnnalInterestRate;
    }

    public void setNominalAnnalInterestRate(BigDecimal nominalAnnalInterestRate) {
        this.nominalAnnalInterestRate = nominalAnnalInterestRate;
    }

    public BigDecimal getMinReqequingBalance() {
        return minReqequingBalance;
    }

    public void setMinReqequingBalance(BigDecimal minReqequingBalance) {
        this.minReqequingBalance = minReqequingBalance;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
