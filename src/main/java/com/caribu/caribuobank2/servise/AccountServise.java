package com.caribu.caribuobank2.servise;

import com.caribu.caribuobank2.domin.SavingsAccunt;
import com.caribu.caribuobank2.repository.AccountRepository;
import com.caribu.caribuobank2.servise.dto.SavingAccountDto;
import com.caribu.caribuobank2.servise.mapper.AccountMaper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AccountServise {

private final AccountRepository accountRepository;

private final AccountMaper accountMaper;
    public AccountServise(AccountRepository accountRepository, AccountMaper accountMaper) {
        this.accountRepository = accountRepository;
        this.accountMaper = accountMaper;
    }


    public SavingAccountDto save(SavingAccountDto savingAccountDto) {
        SavingsAccunt savingsAccunt=accountMaper.toEntity(savingAccountDto);
        accountRepository.save(savingsAccunt);
        return accountMaper.toDto(savingsAccunt);


    }


    public List<SavingAccountDto> findAll() {

        return accountRepository.findAll().stream().map(accountMaper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    public Optional<SavingAccountDto> findByid(long id) {
     Optional<SavingAccountDto>savingAccountDto=accountRepository.findById(id).map(accountMaper::toDto);
     return savingAccountDto;


    }

    public void deletByid(long id) {
        accountRepository.deleteById(id);
    }

    public SavingAccountDto update(SavingAccountDto savingAccountDto, long id) {
        SavingsAccunt savingsAccunt1=accountMaper.toEntity(savingAccountDto);
        SavingsAccunt savingsAccunt=new SavingsAccunt();
        savingsAccunt.setId(id);
        savingsAccunt.setStatuse(savingsAccunt1.getStatuse());
        savingsAccunt.setClient(savingsAccunt1.getClient());
        savingsAccunt.setMinReqequingBalance(savingsAccunt1.getMinReqequingBalance());
        savingsAccunt.setAccountBalance(savingsAccunt1.getAccountBalance());
        savingsAccunt.setAccuntNumber(savingsAccunt1.getAccuntNumber());
        savingsAccunt.setExterlId(savingsAccunt1.getExterlId());
        savingsAccunt.setNominalAnnalInterestRate(savingsAccunt1.getNominalAnnalInterestRate());
        SavingsAccunt savingsAccunt2= accountRepository.save(savingsAccunt);
        return accountMaper.toDto(savingsAccunt2);




    }
}
