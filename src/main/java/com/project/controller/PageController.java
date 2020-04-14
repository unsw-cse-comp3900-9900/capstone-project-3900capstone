package com.project.controller;

import com.project.pojo.Books;
import com.project.pojo.Users;
import com.project.service.BookServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    BookServiceImpl bookService;

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
