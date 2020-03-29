package com.project.controller;

import com.project.pojo.Books;
import com.project.service.CartServiceImpl;
import com.project.service.UserServiceImpl;
import com.project.pojo.Cart;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class cartController{

    @Autowired
    CartServiceImpl cartService;

    @RequestMapping("/cart.html")
    public void queryCartByuserId(Model model) {
        List<Books> cartList = cartService.queryCartByuserId(1);
        model.addAttribute("list", cartList);
    }
}