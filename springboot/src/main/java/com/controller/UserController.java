package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/adduser")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "input";
        }
        userService.addUser(user);
        return "OK";
    }

    @RequestMapping("/adduserui")
    public String show(User user) {
        return "input";
    }

    @RequestMapping("/findall")
    public String findall(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return "showall";
    }

    @RequestMapping("/findbyid")
    public String findById(Integer id,Model model) {
        model.addAttribute("user", userService.selectById(id));
        return "update";
    }

    @RequestMapping("/edituser")
    @ResponseBody
    public String updateUser(User user) {
        userService.updateById(user);
        return "OK";
    }

    @RequestMapping("/deletebyid")
    public String deleteUser(int id) {
        userService.deleteById(id);
        return "redirect:/findall";
    }
}
