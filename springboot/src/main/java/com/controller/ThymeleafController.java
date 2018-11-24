package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ThymeleafController {
    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("msg", "My first Thymeleaf");
        model.addAttribute("key", new Date());
        return "index";
    }
//    @RequestMapping("/{page}")
//    public String show2(@PathVariable  String page) {
//        return page;
//    }
    @RequestMapping("/show2")
    public String show3() {
        return "th_url";
    }
}
