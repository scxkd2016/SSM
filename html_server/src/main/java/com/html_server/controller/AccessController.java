package com.html_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessController {
    @RequestMapping("/access")
    public String access() {
        return "mainexec";
    }
}
