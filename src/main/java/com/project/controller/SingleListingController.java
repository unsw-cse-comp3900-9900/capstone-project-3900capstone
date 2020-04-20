package com.project.controller;

import com.project.pojo.Books;
import com.project.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleListingController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/singleListing")
    public String singleListing(Integer id, Model model)
    {
        Books book = bookService.queryBooksById(id);

        Integer i = bookService.updateClickTime(id);

        model.addAttribute("book", book);

        return "singleListing";
    }

}
