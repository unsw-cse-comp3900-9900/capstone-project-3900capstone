package com.project.controller;


import com.project.pojo.Books;
import com.project.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/onlySearch")
    public String onlySearch(@RequestParam(required = false, name = "fir") String fir,
                             @RequestParam(required = false, name ="search") String search,
                             @RequestParam(required = false, name ="publisher") String publisher,
                             @RequestParam(required = false, name ="author") String author,
                             Model model)
    {
        String bookName = search + "%";
        publisher = publisher + "%";
        author = author + "%";

//        if (publisher != null)
//        {
//            publisher = "%" + publisher + "%";
//        }
//        else
//        {
//            publisher = "%" + search + "%";
//        }
//
//        if(author != null)
//        {
//            author = "%" + author + "%";
//        }
//        else {
//            author = "%" + search + "%";
//        }



        if (bookName.equals("%"))
        {
            bookName = "null%";
        }

        if (publisher.equals("%"))
        {
            publisher = "null%";
        }

        if (author.equals("%"))
        {
            author = "null%";
        }

        int offset = 0;
        int limit = 4;



        List<Books> booksList = bookService.fuzzyQuery(bookName, author, publisher, offset, limit);
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



        model.addAttribute("bks1", first);
        model.addAttribute("bks2", second);

        model.addAttribute("bks", booksList1);

        if (booksList.isEmpty())
        {
            model.addAttribute("noBook", "NO RESULT!");
        }



        return "listings";
    }

}
