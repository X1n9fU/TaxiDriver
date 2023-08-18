package com.example.TaxiDriver.service;

import com.example.TaxiDriver.dto.TaxiDriverDto;
import com.example.TaxiDriver.entity.TaxiDriverEntity;
import com.example.TaxiDriver.repository.TaxiDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxiDriverService {
    private final TaxiDriverRepository taxiDriverRepository;
    public TaxiDriverEntity login(TaxiDriverDto taxiDriverDto) {
        //택시 기사님의 전화번호로 DB에서 정보(Entity)를 가져온다.
        TaxiDriverEntity taxiDriverEntity = taxiDriverRepository.findByPhone(taxiDriverDto.getPhone());
        String phone = taxiDriverEntity.getPhone();
        String password = taxiDriverEntity.getPassword();
        if (phone.equals(taxiDriverDto.getPhone()) && password.equals(taxiDriverDto.getPassword())){
            return taxiDriverEntity;
        }
        else return null;
    }

    public TaxiDriverDto getInfo(String driverPhone) {
        TaxiDriverEntity taxiDriverEntity = taxiDriverRepository.findByPhone(driverPhone);
        return TaxiDriverDto.toDTO(taxiDriverEntity);

    }
}
