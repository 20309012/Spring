package com.caribu.caribuobank2.servise.mapper;

import com.caribu.caribuobank2.domin.Office;
import com.caribu.caribuobank2.domin.SavingAcuontAction;
import com.caribu.caribuobank2.servise.dto.SavingAcuontActionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface SavingAcuontActionMapper {
   // @Mapping(source = " SavingAcuontAction ",target ="savingAconttransacsion")
    SavingAcuontActionDto toDto(SavingAcuontAction savingAcuontAction);
   // @Mapping(source = " savingAconttransacsionType ",target ="savingAconttransacsion")
    SavingAcuontAction toEntity(SavingAcuontActionDto savingAcuontActionDto);
   // default SavingAcuontAction fromId(Long id) {

//        if(id==null) {return null;}
//        SavingAcuontAction  SavingAcuontAction=new SavingAcuontAction();
//        SavingAcuontAction .setId(id);
//        return SavingAcuontAction;
//    }
}
