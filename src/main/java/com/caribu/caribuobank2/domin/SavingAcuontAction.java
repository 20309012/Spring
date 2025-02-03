package com.caribu.caribuobank2.domin;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m-acuontAction")
@SequenceGenerator(name = "sequence-generator",initialValue = 1)
public class SavingAcuontAction extends Abstrackpersistance{
    @Enumerated(EnumType.STRING)
    private SavingAconttransacsionType savingAconttransacsionType;
    @Temporal(TemporalType.DATE)
    private Date dateof;
    private BigDecimal amount;
    private BigDecimal amunt;

    private BigDecimal runningBalance;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "savingsaccunt")
    private SavingsAccunt savingsAccunt;

    public SavingAcuontAction() {
    }

    public SavingAconttransacsionType getTransacsiontype() {
        return savingAconttransacsionType;
    }

    public SavingAconttransacsionType getSavingAconttransacsionType() {
        return savingAconttransacsionType;
    }

    public void setSavingAconttransacsionType(SavingAconttransacsionType savingAconttransacsionType) {
        this.savingAconttransacsionType = savingAconttransacsionType;
    }

    public Date getDateof() {
        return dateof;
    }

    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmunt() {
        return amunt;
    }

    public void setAmunt(BigDecimal amunt) {
        this.amunt = amunt;
    }

    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }

    public SavingsAccunt getSavingsAccunt() {
        return savingsAccunt;
    }

    public void setSavingsAccunt(SavingsAccunt savingsAccunt) {
        this.savingsAccunt = savingsAccunt;
    }
}
