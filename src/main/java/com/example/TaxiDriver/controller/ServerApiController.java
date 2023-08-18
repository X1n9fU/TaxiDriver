package com.example.TaxiDriver.controller;

import com.example.TaxiDriver.dto.TaxiDriverDto;
import com.example.TaxiDriver.entity.UserDB;
import com.example.TaxiDriver.repository.TaxiDriverRepository;
import com.example.TaxiDriver.repository.UserRepository;
import com.example.TaxiDriver.service.ApiService;
import com.example.TaxiDriver.service.TaxiDriverService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TaxiDriver.dto.User; // User 클래스의 패키지 경로를 정확하게 수정해야 합니다.

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ServerApiController {

    private final UserRepository userRepository;
    private final TaxiDriverRepository taxiDriverRepository;
    private final TaxiDriverService taxiDriverService;
    private String clientPhone;


    //손님 앱에서 현위치랑, 목적지를 받아옴
    @ResponseBody
    @PostMapping(value = "/taxi/phone/{phone}")
    public User post(@RequestBody User u,@PathVariable String phone){
        UserDB userdb = userRepository.findByUserName(phone);
        User user = User.toDTO(userdb);
        log.info("From client request: {}", user);
        clientPhone = phone;
        return u;
    }


    @RequestMapping(value = "/taxi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> get() {
        User user = User.toDTO(userRepository.findByUserName(clientPhone));
        log.info("client request: {}", user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/reject", produces = MediaType.APPLICATION_JSON_VALUE)
    public void nullPhone() {
        clientPhone=null;
    }




    private final ApiService apiService;

    //손님에게 보내는 기사님 정보
    @RequestMapping("/client")
    public TaxiDriverDto getTaxiDriver(HttpServletRequest request){
        HttpSession session = request.getSession();
        String driver = (String) session.getAttribute("driverPhone");
        //아직 프론트에서 로그인하고 정보를 가져오는 것이 구현이 덜 되었음. 임의로 설정
        TaxiDriverDto taxi = TaxiDriverDto.toDTO(taxiDriverRepository.findByPhone(driver));
        System.out.println(taxi);
        return apiService.post(taxi);
    }

    @GetMapping("/taxiDriver")
    public ResponseEntity<TaxiDriverDto> taxiInfo(HttpServletRequest request){
        HashMap<String,Object> taxi = new HashMap<>();
        HttpSession session = request.getSession();
//        String phone = (String) session.getAttribute("driverPhone");
        //기사님 전화번호 세션에 저장
        String phone="01012345678";
        TaxiDriverDto taxiDriverDto = taxiDriverService.getInfo(phone);
        return ResponseEntity.ok(taxiDriverDto);
    }

}
