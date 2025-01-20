package com.fintech_lab.Roll31;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Roll31Controller
{
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello world from controller";
    }
}