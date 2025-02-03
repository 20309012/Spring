package com.caribu.caribuobank2.rest;

import com.caribu.caribuobank2.domin.SavingAcuontAction;
import com.caribu.caribuobank2.repository.SavingAcuontActionRepository;
import com.caribu.caribuobank2.servise.SavingAcuotActionServise;
import com.caribu.caribuobank2.servise.dto.SavingAcuontActionDto;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SavingAccontActionResource {
    private final SavingAcuotActionServise savingAcuotActionServise;
    private final SavingAcuontActionRepository savingAcuontActionRepository;
    public SavingAccontActionResource(SavingAcuotActionServise savingAcuotActionServise, SavingAcuontActionRepository savingAcuontActionRepository) {
        this.savingAcuotActionServise = savingAcuotActionServise;
        this.savingAcuontActionRepository = savingAcuontActionRepository;
    }
    @GetMapping("/getacant")
    public List<SavingAcuontActionDto>getall(){
        return   savingAcuotActionServise.findall();

    }
@PostMapping("/post/{savings-id}/deposit")
    public SavingAcuontActionDto deposit(@PathVariable Long savings_id, @RequestBody SavingAcuontActionDto savingAcuontActionDto){
   SavingAcuontActionDto result=savingAcuotActionServise.handelDeposet(savings_id,savingAcuontActionDto);
   return result;
}

    @GetMapping("/getacan")
    public List<SavingAcuontAction>getal(){
        return   savingAcuontActionRepository.findAll().stream().collect(Collectors.toCollection(LinkedList::new));

    }


}
