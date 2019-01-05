package com.pk_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AccessController {
    @RequestMapping("/access")
    public String access() {
        System.out.println("here");
        return "mainexec";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}
