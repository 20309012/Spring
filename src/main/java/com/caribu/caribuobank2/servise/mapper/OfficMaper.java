package com.caribu.caribuobank2.servise.mapper;

import com.caribu.caribuobank2.domin.Office;
import com.caribu.caribuobank2.servise.dto.OfficDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses={})
public interface OfficMaper {
    @Mapping(source = "parent.id",target = "parentId")
   OfficDto toDto(Office office);
    @Mapping(source = "parentId",target = "parent.id")
    Office toEntity(OfficDto officDto);
   default Office fromId(Long id) {

        if(id==null) {return null;}
        Office office=new Office();
        office.setId(id);
        return office;
    }

}
