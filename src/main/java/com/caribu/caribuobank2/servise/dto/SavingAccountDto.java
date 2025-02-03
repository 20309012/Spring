package com.caribu.caribuobank2.servise.dto;

import com.caribu.caribuobank2.domin.SavingsAccuntStatuseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.math.BigDecimal;
@Mapper
public class SavingAccountDto implements Serializable {
    private String accuntNumber;
    private String exterlId;
  //  @Enumerated(EnumType.STRING)
    private SavingsAccuntStatuseType statuse;
    //    @Column(name = "nominalannualinterestrate",scale = 6,precision = 19,nullable = false)
    private BigDecimal nominalAnnalInterestRate;
    //   @Column(name = "minrequiredopeningbalance",scale = 6,precision = 19,nullable = false)
    private BigDecimal minReqequingBalance;
    private Long clintId;
    // @Column(name = "accontblancedriver",scale = 6,precision = 12,nullable = false)
    private BigDecimal accountBalance=BigDecimal.ZERO;

    public Long getClintId() {
        return clintId;
    }

    public void setClintId(Long clintId) {
        this.clintId = clintId;
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
}
