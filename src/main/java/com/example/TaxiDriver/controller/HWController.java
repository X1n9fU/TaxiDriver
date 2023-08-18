package com.example.TaxiDriver.controller;

import com.example.TaxiDriver.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class HWController {


    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
