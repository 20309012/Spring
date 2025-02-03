package com.caribu.caribuobank2.repository;

import com.caribu.caribuobank2.domin.SavingsAccunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<SavingsAccunt,Long> {
}
