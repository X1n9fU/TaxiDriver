package com.example.TaxiDriver.dto;


import com.example.TaxiDriver.entity.TaxiDriverEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaxiDriverDto {
    //택시 기사님 정보
    private String phone;
    private String password;
    private String name;
    private String CarNumber;
    private String CarType;

    public static TaxiDriverDto toDTO(TaxiDriverEntity taxiDriverEntity){
        TaxiDriverDto taxiDriverDto = new TaxiDriverDto();
        taxiDriverDto.setName(taxiDriverEntity.getName());
        taxiDriverDto.setPhone(taxiDriverEntity.getPhone());
        taxiDriverDto.setCarType(taxiDriverEntity.getCarType());
        taxiDriverDto.setCarNumber(taxiDriverEntity.getCarNumber());
        return taxiDriverDto;
    }
}
