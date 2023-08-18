package com.example.TaxiDriver.controller;

import com.example.TaxiDriver.dto.TaxiDriverDto;
import com.example.TaxiDriver.entity.TaxiDriverEntity;
import com.example.TaxiDriver.service.TaxiDriverService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins="*", allowedHeaders = "*")
public class TaxiDriverController {
    private final TaxiDriverService taxiDriverService;

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody TaxiDriverDto taxiDriverDto, HttpServletRequest request){
        TaxiDriverEntity taxiDriver = taxiDriverService.login(taxiDriverDto);
        if (taxiDriver==null) ResponseEntity.ok(0);
        else {
            HttpSession session = request.getSession();
            session.setAttribute("driverPhone", taxiDriver.getPhone());
            return ResponseEntity.ok(1);
        }
        return null;
    }





}

