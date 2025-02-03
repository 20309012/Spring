package com.caribu.caribuobank2.repository;

import com.caribu.caribuobank2.domin.SavingAcuontAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAcuontActionRepository extends JpaRepository<SavingAcuontAction, Long> {
}
