package com.project.controller;

import com.project.pojo.Users;
import com.project.service.BookServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/cart")
    public String queryCartByUserId(Model model) {
        Subject subject = SecurityUtils.getSubject();

        Users currUser = (Users) subject.getPrincipal();

        List<HashMap> cartList = bookService.queryCartByUserId(currUser.getUserId());

        if (cartList.size() != 0) {
            model.addAttribute("list", cartList);
            Float total = 0.0F;
            for (HashMap temp : cartList) {
                total += (Float) temp.get("price");
            }
            model.addAttribute("total", total);
        }
        return "cart";
    }

    @RequestMapping("/delete/{ubId}")
    public String deleteCartById(Model model, @PathVariable("ubId") Integer ubId) {
        bookService.deleteCartById(ubId);
        return "redirect:/cart";
    }
}
