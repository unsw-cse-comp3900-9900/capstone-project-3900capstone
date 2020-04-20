package com.project.controller;

import com.project.pojo.Books;
import com.project.pojo.Users;
import com.project.service.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListingController {

    @Autowired
    BookServiceImpl bookService;



    @RequestMapping("/listings")
    public String show(@RequestParam(required = false, defaultValue = "1") String fir, @RequestParam(required = false) String next, Model model)
    {

        int offset = (Integer.parseInt(fir) - 1) * 4;
        int limit = 4;

        List<Books> booksList = bookService.queryBooksList(offset, limit);

        List<Books> booksList1 = bookService.queryBooksList(0, 5);

        List<Books> first = new ArrayList<>();
        List<Books> second = new ArrayList<>();

        if (booksList.size() % 2 == 0)
        {
            first = booksList.subList(0,booksList.size()/2);
            second = booksList.subList(booksList.size()/2, booksList.size());
        }
        else {
            first = booksList.subList(0,booksList.size()/2+1);
            second = booksList.subList(booksList.size()/2+1, booksList.size());
        }

        if (booksList.isEmpty())
        {
            model.addAttribute("noBook", "NO RESULT!");
        }




        model.addAttribute("bks1", first);
        model.addAttribute("bks2", second);

        model.addAttribute("bks", booksList1);




        return "listings";
    }




}
