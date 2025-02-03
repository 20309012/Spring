package com.caribu.caribuobank2.servise;

import com.caribu.caribuobank2.domin.SavingAcuontAction;
import com.caribu.caribuobank2.domin.SavingsAccunt;
import com.caribu.caribuobank2.domin.SavingsAccuntStatuseType;
import com.caribu.caribuobank2.repository.AccountRepository;
import com.caribu.caribuobank2.repository.SavingAcuontActionRepository;
import com.caribu.caribuobank2.rest.SavingsAccountResource;
import com.caribu.caribuobank2.servise.dto.SavingAccountDto;
import com.caribu.caribuobank2.servise.dto.SavingAcuontActionDto;
import com.caribu.caribuobank2.servise.mapper.SavingAcuontActionMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavingAcuotActionServise {

    private final SavingAcuontActionRepository acuontActionRepository;
    private final SavingAcuontActionMapper savingAcuontActionMapper;
    private final AccountRepository accountRepository;
    public SavingAcuotActionServise(SavingAcuontActionRepository acuontActionRepository, SavingAcuontActionMapper savingAcuontActionMapper, AccountRepository accountRepository) {
        this.acuontActionRepository = acuontActionRepository;
        this.savingAcuontActionMapper = savingAcuontActionMapper;
        this.accountRepository = accountRepository;
    }

    public List<SavingAcuontActionDto> findall() {
        return acuontActionRepository.findAll().stream().map(savingAcuontActionMapper::toDto).collect(Collectors.toCollection(LinkedList::new));

    }

    public SavingAcuontActionDto handelDeposet(Long savingsId, SavingAcuontActionDto savingAcuontActionDto) {

        Optional<SavingsAccunt> ret= accountRepository.findById(savingsId);
        if (ret.isPresent()) {
            SavingsAccunt savingsAccunt = ret.get();
            validateForAccuntBlock(savingsAccunt);
            SavingAcuontAction savingAcuontAction= savingAcuontActionMapper.toEntity(savingAcuontActionDto);
            savingAcuontAction.setSavingsAccunt(savingsAccunt);
        savingAcuontAction=  acuontActionRepository.save(savingAcuontAction);
            savingAcuontActionDto= savingAcuontActionMapper.toDto(savingAcuontAction);
            savingsAccunt.setAccountBalance(savingAcuontAction.getAmount().add(savingsAccunt.getAccountBalance()));
            accountRepository.save(savingsAccunt);
        }else {
            throw new RuntimeException("SavingAcuontAction not found");
        }
        return savingAcuontActionDto;
    }

    private void validateForAccuntBlock(SavingsAccunt savingsAccunt) {
        final SavingsAccuntStatuseType curentStatuse=savingsAccunt.getStatuse();
        if (SavingsAccuntStatuseType.BLOCK.equals(curentStatuse)){
            throw new RuntimeException("Savings accunt is block");
        }

    }
}
