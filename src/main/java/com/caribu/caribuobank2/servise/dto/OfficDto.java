package com.caribu.caribuobank2.servise.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.Date;
@Mapper
public class OfficDto implements Serializable {
    private Long id;
    @NotNull
    @Size(min = 3, max = 100)
    private String name;
    private Date opning;
    private String Extenalid;

    private Long parentId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
