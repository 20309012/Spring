package com.caribu.caribuobank2.servise.dto;

import com.caribu.caribuobank2.domin.Abstrackpersistance;
import com.caribu.caribuobank2.domin.SavingAconttransacsionType;
import com.caribu.caribuobank2.domin.SavingsAccuntStatuseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Mapper
public class SavingAcuontActionDto  implements Serializable {
   // @Enumerated(EnumType.STRING)
    private SavingAconttransacsionType savingAconttransacsionType;
    private Date dateof;
    private BigDecimal amount;

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
}
