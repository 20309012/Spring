package com.caribu.caribuobank2.rest;

import com.caribu.caribuobank2.domin.SavingsAccunt;
import com.caribu.caribuobank2.repository.AccountRepository;
import com.caribu.caribuobank2.servise.AccountServise;
import com.caribu.caribuobank2.servise.dto.SavingAccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class SavingsAccountResource {
   private final AccountServise accountServise;

    private final AccountRepository accountRepository;
    public SavingsAccountResource(AccountServise accountServise, AccountRepository accountRepository) {
        this.accountServise = accountServise;
        this.accountRepository = accountRepository;
    }


    @PostMapping("/post")
    public SavingAccountDto createAccount(@RequestBody SavingAccountDto savingAccountDto) {

        SavingAccountDto result= accountServise.save(savingAccountDto);
        return result;

    }
    @GetMapping("/get")
    public List<SavingAccountDto> getAccounts() {
     return accountServise.findAll();
// return accountRepository.findAll();


    }

    @GetMapping("/get/{id}")
    public SavingAccountDto findAccount(@PathVariable long id) {
        Optional<SavingAccountDto>savingAccountDto=accountServise.findByid(id);
        return savingAccountDto.get();
    }
@DeleteMapping("/del/{id}")
    public void deleteAccount(@PathVariable long id) {
        accountServise.deletByid(id);
}

@PutMapping("/put/{id}")
public SavingAccountDto updateAccount(@PathVariable long id, @RequestBody SavingAccountDto savingAccountDto) {
        return  accountServise.update(savingAccountDto,id);
}
}
