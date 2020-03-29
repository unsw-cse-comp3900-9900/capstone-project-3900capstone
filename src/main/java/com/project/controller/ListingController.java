package com.project.controller;

import com.project.pojo.Users;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListingController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/onlySearch")
    public String onlySearch()
    {

        return "redirect:/signup.html";
    }







}
