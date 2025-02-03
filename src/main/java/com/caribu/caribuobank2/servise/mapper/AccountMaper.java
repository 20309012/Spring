package com.caribu.caribuobank2.servise.mapper;

import com.caribu.caribuobank2.domin.SavingsAccunt;
import com.caribu.caribuobank2.servise.dto.SavingAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface AccountMaper {

   @Mapping(source = "clintId",target = "client.id")
    SavingsAccunt toEntity(SavingAccountDto savingAccountDto);
  @Mapping(source = "client.id",target = "clintId")
    SavingAccountDto toDto(SavingsAccunt savingsAccunt);
    default SavingsAccunt fromId(Long id) {

        if(id==null) {return null;}
        SavingsAccunt savingsAccunt=new SavingsAccunt();
        savingsAccunt.setId(id);
        return savingsAccunt;
    }


}
