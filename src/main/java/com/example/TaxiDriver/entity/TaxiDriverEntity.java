package com.example.TaxiDriver.entity;

import com.example.TaxiDriver.dto.TaxiDriverDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="taxi_driver")
public class TaxiDriverEntity {
    @Id
    private String phone;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String CarNumber;

    @Column
    private String CarType;



}
