package com.example.springdatabasicdemo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class gide {

    @GetMapping("/gide")
    public String gidePage() {
        return "gide";
    }

}