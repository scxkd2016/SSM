package com.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @RequestMapping("/getmsg")
    public String getMsg() {
        return "haha";
    }
}
