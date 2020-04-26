package com.project.controller;

import com.project.pojo.Books;
import com.project.pojo.Users;
import com.project.service.BookServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PaymentController {

    @Autowired
    BookServiceImpl bookService;

    Map<Integer, Integer> available = new HashMap<>();

    @RequestMapping("/payment")
    public String payment (Model model) {
        Subject subject = SecurityUtils.getSubject();

        Users currUser = (Users) subject.getPrincipal();
        int unavailable = 0;
        List<HashMap> cartList = bookService.queryCartByUserId(currUser.getUserId());
        for (HashMap item : cartList) {
            if (checkAvailable((Integer) item.get("bookId"), (Integer) item.get("numbers"))) {
                available.put((Integer) item.get("bookId"), (Integer) item.get("numbers"));
            }
            else {
                unavailable++;
            }
        }

        if (unavailable == 0) {
            return updateDb(currUser);
        }
        else {
            if (available.size() == 0) {
                model.addAttribute("message", "all");
            }
            else {
                model.addAttribute("message", "some");
            }
            return "payment";
        }
    }

    @RequestMapping("/onlyAvailable")
    public String onlyAvailable() {
        Subject subject = SecurityUtils.getSubject();
        Users currUser = (Users) subject.getPrincipal();
        return updateDb(currUser);
    }

    private boolean checkAvailable(Integer id, Integer qty) {
        Books book = bookService.queryBooksById(id);
        if (book == null) {
            return false;
        }
        return book.getBookCounts() >= qty;
    }

    private void updateStock(Integer copies, Integer id) {
        bookService.updateStock(copies, id);
    }

    private void updateCart(Integer id, Users currUser) {
        bookService.updateCartStatus(currUser.getUserId(), id);
    }

    private String updateDb(Users currUser) {
        for (Map.Entry<Integer, Integer> temp : available.entrySet()) {
            Integer id = temp.getKey();
            Integer copies = temp.getValue();
            updateStock(copies, id);
            updateCart(id, currUser);
        }
        available.clear();
        return "redirect:/confirmation.html";
    }
}
