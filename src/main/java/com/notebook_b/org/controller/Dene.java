package com.notebook_b.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deneme")
public class Dene {

    @GetMapping("/getdeneme")
    public String getDeneme(){return "Deneme Başarılı";}
}
