package com.project.controller;

import com.project.pojo.Books;
import com.project.service.BookServiceImpl;
import com.project.service.UserServiceImpl;
import com.project.pojo.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {


    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookServiceImpl bookService;


    @RequestMapping("/login")

    public String login(@RequestParam("email") String email,
                        @RequestParam("pass") String password,
                        Model model)
    {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(email, password);


        try {
            subject.login(token);
            Users user = (Users) SecurityUtils.getSubject().getPrincipal();

            String department = user.getDepartment();

            if(!department.equals(""))
            {
                Books rec1 = bookService.recommendation(department, 0, 1);
                Books rec2 = bookService.recommendation(department, 1, 1);
                Books rec3 = bookService.recommendation(department, 2, 1);
                Books rec4 = bookService.recommendation(department, 3, 1);

                model.addAttribute("bk1",rec1);

                model.addAttribute("bk2",rec2);

                model.addAttribute("bk3",rec3);

                model.addAttribute("bk4",rec4);
            }
            else {

                List<Books> booksList = bookService.queryBooksList(0, 4);

                int count = 1;
                for(Books b : booksList)
                {
                    String book = "bk" + count;
                    model.addAttribute(book, b);
                    count += 1;
                }

            }


            return  "main";

        }
        catch (IncorrectCredentialsException e){
            model.addAttribute("msg", "Invalid Username or Password");
            return "login";
        }
        catch (UnknownAccountException e){
            model.addAttribute("msg", "Invalid Username or Password");
            return "login";
        }




    }


    @RequestMapping("/unauth")
    public String unauthorized(){


        return "unauth";
    }





}
