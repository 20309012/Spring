package com.caribu.caribuobank2.rest;

import com.caribu.caribuobank2.servise.ClientServise;
import com.caribu.caribuobank2.servise.dto.ClientDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientResurce {

 private final ClientServise clientServise ;

    public ClientResurce(ClientServise clientServise) {
        this.clientServise = clientServise;
    }

    @PostMapping("/ret")
    public ClientDto creatclient(@RequestBody ClientDto clientDto) {
        return  clientServise.save(clientDto);
    }
    @GetMapping("/clint")
    public List<ClientDto> getclient() {

   return   clientServise.getAll();

    }
    @GetMapping("/clint2/{id}")
    public ClientDto getclient(@PathVariable Long id) {
       Optional<ClientDto>clientDto = clientServise.findById(id);

       if(clientDto.isPresent()) {
           return clientDto.get();
       }
else {
    return null;
       }
    }

    @PutMapping("/clint33/{id}")
    public ClientDto updete(@PathVariable Long id,@RequestBody ClientDto clientDto){
       ClientDto result= clientServise.updete(clientDto,id);
    return result;
    }
      @DeleteMapping("/delete/{id}")
    public void delety(@PathVariable Long id) {
        clientServise.deletById(id);
      //  return null;
      }

}
