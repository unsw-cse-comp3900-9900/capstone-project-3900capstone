package com.project.controller;

import com.project.pojo.Books;
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

    @RequestMapping("/addCart")
    public String singleListing(Integer id ,Model model)
    {
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Books book = bookService.oneBook(user.getUserId(), id);

        Books nowBook = bookService.queryBooksById(id);

        if (book == null)
        {
            Integer i = bookService.addToCart(user.getUserId(), id);
        }
        else {
            Integer quantity = bookService.queryCartItem(user.getUserId(), id);
            Integer i = bookService.updateCart(user.getUserId(), id, quantity + 1);
        }

        model.addAttribute("msg", "Success!");

        model.addAttribute("book", nowBook);



        return "singleListing";
    }

    @RequestMapping("/addCopy")
    public String addCopy(Integer id, Model model){
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        Integer quantity = bookService.queryCartItem(user.getUserId(), id);
        bookService.updateCart(user.getUserId(), id, quantity + 1);

        return "redirect:/cart";
    }

    @RequestMapping("/deleteCopy")
    public String deleteCopy(Integer id, Integer ubId, Model model){
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        Integer quantity = bookService.queryCartItem(user.getUserId(), id);
        if (quantity == 1) {
            bookService.deleteCartById(ubId);
        }
        else {
            bookService.updateCart(user.getUserId(), id, quantity - 1);
        }
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String queryCartByUserId(Model model) {
        Subject subject = SecurityUtils.getSubject();

        Users currUser = (Users) subject.getPrincipal();

        List<HashMap> cartList = bookService.queryCartByUserId(currUser.getUserId());

        if (cartList.size() != 0) {
            model.addAttribute("list", cartList);
            Float total = 0.0F;
            for (HashMap temp : cartList) {
                total += (Float) temp.get("price") * (Integer) temp.get("numbers");
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
