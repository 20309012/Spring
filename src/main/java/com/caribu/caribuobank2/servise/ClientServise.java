package com.caribu.caribuobank2.servise;

import com.caribu.caribuobank2.domin.Client;
import com.caribu.caribuobank2.repository.ClientRepository;
import com.caribu.caribuobank2.servise.dto.ClientDto;
import com.caribu.caribuobank2.servise.mapper.ClientMaper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServise {

    private final ClientRepository clientRepository;
    private final ClientMaper clientMaper;

    public ClientServise(ClientRepository clientRepository, ClientMaper clientMaper) {
        this.clientRepository = clientRepository;
        this.clientMaper = clientMaper;
    }

    public ClientDto save(ClientDto clientDto) {
        Client client=clientMaper.toEntity(clientDto);
        clientRepository.save(client);
        return clientMaper.toDto(client);
    }

    public List<ClientDto> getAll() {
        return clientRepository.findAll().stream().map(clientMaper::toDto).collect(Collectors.toList());

    }

    public Optional<ClientDto> findById(Long id) {

 Optional<ClientDto>clientDto=clientRepository.findById(id).map(clientMaper::toDto);
 return clientDto;

    }

    public ClientDto updete(ClientDto clientDto,Long id) {
        Client client1=clientMaper.toEntity(clientDto);


       Client client2=new Client();
        client2.setId(id);
       client2.setDetaOfBirth(client1.getDetaOfBirth());
      client2.setOffice(client1.getOffice());
       client2.setEmailAdress(client1.getEmailAdress());
       client2.setExternalId(client1.getExternalId());
       client2.setMiddlename(client1.getMiddlename());
       client2.setLastName(client1.getLastName());

     Client client=  clientRepository.save(client2);

      return clientMaper.toDto(client);
    }

    public void deletById(Long id) {
        clientRepository.deleteById(id);

    }
}
