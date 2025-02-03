package com.caribu.caribuobank2.repository;

import com.caribu.caribuobank2.domin.Office;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface OfficRepository extends JpaRepository<Office,Long> {
}
