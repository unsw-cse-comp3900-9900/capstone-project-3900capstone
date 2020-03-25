package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/loginPage")
    public String login()
    {
        return "redirect:/login.html";
    }


    @RequestMapping("/signupPage")
    public String signup()
    {

        return "redirect:/signup.html";
    }

}
