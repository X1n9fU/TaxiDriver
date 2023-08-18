package com.example.TaxiDriver.service;

import com.example.TaxiDriver.dto.TaxiDriverDto;
import com.example.TaxiDriver.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ApiService {

    //손님에게 보내는 기사님 정보
    public TaxiDriverDto post(TaxiDriverDto taxiDriverDto) {
        URI uri = UriComponentsBuilder.
                fromHttpUrl("http://localhost:8082")
                .path("/api/taxi")
                //기사님의 이름, 전화번호, 차 정보를 post로 보낸다.
                .encode()
                .build()
                .toUri();

        System.out.println(uri);
        //넘겨줄 req 객체를 만들고, 넘겨줄 내용을 넣어준다.
        TaxiDriverDto req = new TaxiDriverDto();
        req.setName(taxiDriverDto.getName());
        req.setPhone(taxiDriverDto.getPhone());
        req.setCarNumber(taxiDriverDto.getCarNumber());
        req.setCarType(taxiDriverDto.getCarType());

        RestTemplate restTemplate = new RestTemplate();

        //post 형식으로 보내줄 entity 구축
        ResponseEntity<TaxiDriverDto> response = restTemplate.postForEntity(uri,req,TaxiDriverDto.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

    }
}
