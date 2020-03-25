package com.project.controller;

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

@Controller
public class LoginController {


    @Autowired
    UserServiceImpl userService;





    @RequestMapping("/login")

    public String login(@RequestParam("email") String email,
                        @RequestParam("pass") String password,
                        Model model)
    {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(email, password);


        try {
            subject.login(token);
            return "redirect:/listings.html";
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
