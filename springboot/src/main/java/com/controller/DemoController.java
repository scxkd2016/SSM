package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("/demo2")
    public String demo2() {
        int num = 1 / 0;
        return "demo";
    }

}
