package com.project.controller;


import com.project.pojo.Users;
import com.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    @Autowired
    UserServiceImpl userService;





    @RequestMapping("/signup")
    public String signup(@RequestParam("userName") String userName,
                         @RequestParam("email") String email,
                         @RequestParam("zId") Integer zId,
                         @RequestParam("password") String password,
                         @RequestParam("check") String check,
                         Model model )
    {

        if (!password.equals(check))
        {
            model.addAttribute("msg", "Different password!");
            return "/signup";
        }
        else {
            Users usercheck1 = userService.queryUsersByEmail(email);
            Users usercheck2 = userService.queryUsersByUsername(userName);
            Users usercheck3 = userService.queryUsersByzId(zId);


            if (usercheck2 != null)
            {

                model.addAttribute("msg", "Username exists! Change another!");
                return "/signup";
            }
            else if (usercheck1 != null)
            {

                model.addAttribute("msg", "Email address exists! Change another!");
                return "/signup";
            }
            else if (usercheck3 != null)
            {

                model.addAttribute("msg", "zID exists! Change another!");
                return "/signup";
            }

            else
            {

                userService.addUser(new Users(null, zId, userName, password, 0, email, "", "", "user:normal"));
                return "redirect:/login.html";
            }

        }


    }

}
