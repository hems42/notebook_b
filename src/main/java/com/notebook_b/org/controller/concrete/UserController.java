package com.notebook_b.org.controller.concrete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/getdeneme")
    public String getDeneme(){return "Deneme Başarılı";}

}
