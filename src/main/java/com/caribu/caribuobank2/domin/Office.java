package com.caribu.caribuobank2.domin;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * affice Enttity
 */
@Table(name = "m-office",uniqueConstraints = {@UniqueConstraint(columnNames= {"name"},name = "name-Unice"),
@UniqueConstraint(columnNames = {"opning"},name = "opning-DataUnic")})
@Entity
@SequenceGenerator(name = "  sequence-Genarat",initialValue = 1,sequenceName = "office-sequnce")
public class Office extends Abstrackpersistance implements Serializable {

    String name;

    @Temporal(TemporalType.DATE)
    Date opning;
    private String Extenalid;

    public Office() {
    }


    @OneToMany(mappedBy = "parent",fetch=FetchType.LAZY)
    private Set<Office > cheldren=new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent-id")
    private Office parent;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpning() {
        return opning;
    }

    public void setOpning(Date opning) {
        this.opning = opning;
    }

    public String getExtenalid() {
        return Extenalid;
    }

    public void setExtenalid(String extenalid) {
        Extenalid = extenalid;
    }

    public Set<Office> getCheldren() {
        return cheldren;
    }

    public void setCheldren(Set<Office> cheldren) {
        this.cheldren = cheldren;
    }

    public Office getParent() {
        return parent;
    }

    public void setParent(Office parent) {
        this.parent = parent;
    }
}


