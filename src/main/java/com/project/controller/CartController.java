package com.project.controller;

import com.project.pojo.Books;
import com.project.pojo.Users;
import com.project.service.BookServiceImpl;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.SecurityUtils;

import java.util.HashMap;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/cart.html")
    public String queryCartByuserId(Model model) {
        Subject subject = SecurityUtils.getSubject();
        Users currentUser = (Users) subject.getPrincipal();

        if (currentUser != null) {
            List<HashMap> cartList = bookService.queryCartByuserId(currentUser.getUserId());
            if (cartList.size() != 0) {
                model.addAttribute("list", cartList);
            }
            return "cart";
        }
        else {
            return "index";
        }
    }

    @RequestMapping("/delete/{ubId}")
    public String deleteCartById(Model model, @PathVariable("ubId") Integer ubId) {
        bookService.deleteCartById(ubId);
        return "redirect:/cart.html";
    }

    @RequestMapping("/confirmation")
    public String goPayment() {
        return "redirect:/confirmation.html";
    }
}
