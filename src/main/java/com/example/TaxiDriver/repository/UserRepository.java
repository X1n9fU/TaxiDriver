package com.example.TaxiDriver.repository;


import com.example.TaxiDriver.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDB, Integer> {

    UserDB findByUserName(String userName);

    UserDB findByToken(String token);

    void deleteByUserName(String userName);
}
