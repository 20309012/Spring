package com.caribu.caribuobank2.servise.mapper;


import com.caribu.caribuobank2.domin.Client;
import com.caribu.caribuobank2.servise.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface ClientMaper {

    @Mapping(source = "office.id",target = "officeId")
    ClientDto toDto(Client client);
    @Mapping(source ="officeId",target = "office.id")
    Client toEntity(ClientDto clientDto);
    default Client fromId(Long id) {

        if(id==null) {return null;}
        Client client=new Client();
        client.setId(id);
        return client;
    }

}
