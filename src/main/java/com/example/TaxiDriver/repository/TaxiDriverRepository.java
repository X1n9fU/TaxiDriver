package com.example.TaxiDriver.repository;

import com.example.TaxiDriver.entity.TaxiDriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiDriverRepository extends JpaRepository<TaxiDriverEntity, Long> {
    TaxiDriverEntity findByPhone(String phone);
}
