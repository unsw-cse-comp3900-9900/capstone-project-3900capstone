package com.project.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","Logout!");
        return "login";
    }

}
