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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/add")
    public String addBook(@RequestParam("bookName") String bookName,
                          @RequestParam("price") Float price,
                          @RequestParam("detail") String detail,
                          @RequestParam("publisher") String publisher,
                          @RequestParam("author") String author,
                          @RequestParam("department") String department,
                          @RequestParam("count") Integer bookCounts,
                          Model model) {

        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Integer userId = user.getUserId();

        bookService.addBook(new Books(null, bookName, price, bookCounts, detail, publisher, author, null, 0, department, userId));

        //bookService.addAllBook(new Books(null, bookName, price, 1, detail, publisher, author, null, 0, department, userId));

        model.addAttribute("msg", "Success!");

        return "add";
    }

    @RequestMapping("/updateBookPage")
    public String updateBook(Model model)
    {
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        List<Books> booksList = bookService.queryBooksByAdminId(user.getUserId());



        model.addAttribute("books", booksList);


        return "updateBook";
    }

    @RequestMapping("/removePage/{id}")
    public String removeBook(@PathVariable("id") Integer id,
                          Model model) {

        Books books = bookService.queryBooksById(id);

        model.addAttribute("book", books);


        return "delete";
    }

    @RequestMapping("/removeBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id,
                             @RequestParam("password") String password,
                             Model model) {

        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Books books = bookService.queryBooksById(id);



        if (user.getUserPwd().equals(password))
        {
            bookService.deleteBook(id);

            List<Books> booksList = bookService.queryBooksByAdminId(user.getUserId());


            model.addAttribute("books", booksList);

            model.addAttribute("msg", "Success!");

            return "updateBook";

        }
        else {
            model.addAttribute("msg", "Wrong password!");
            model.addAttribute("book", books);
            return "delete";

        }
    }


    //modify-----------

    @RequestMapping("/modifyPage/{id}")
    public String modifyBook(@PathVariable("id") Integer id,
                             Model model) {

        Books books = bookService.queryBooksById(id);

        model.addAttribute("book", books);


        return "modify";
    }


    @RequestMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") Integer id,
                             @RequestParam(required = false, name = "price") Float price,
                             @RequestParam(required = false,name = "detail") String detail,
                             @RequestParam(required = false, name = "publisher") String publisher,
                             @RequestParam(required = false, name = "author") String author,
                             @RequestParam(required = false, name = "count") Integer bookCounts,
                             Model model) {

        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        Books book = bookService.queryBooksById(id);

        if (price == null)
        {
            price = book.getPrice();
        }

        if (detail.equals(""))
        {
            detail = book.getDetail();
        }

        if (publisher.equals(""))
        {
            publisher = book.getPublisher();
        }

        if (author.equals(""))
        {
            author = book.getAuthor();
        }



        Integer integer = bookService.updateBook(new Books(id, book.getBookName(), price, bookCounts, detail,
                publisher, author, null, book.getClickTime(), book.getDepartment(), user.getUserId()));


        List<Books> booksList = bookService.queryBooksByAdminId(user.getUserId());



        model.addAttribute("books", booksList);


        return "updateBook";
    }


}
