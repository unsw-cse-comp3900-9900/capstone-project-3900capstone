package com.project.controller;


import com.project.pojo.Users;
import com.project.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProfileController {

    @Autowired
    UserServiceImpl userService;



    @RequestMapping("/changePwdPage")
    public String changePwdPage(Model model) {

        Subject subject = SecurityUtils.getSubject();
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Users u = userService.queryUsersById(user.getUserId());

        model.addAttribute("user", u);


        return "changePwd";
    }

    @RequestMapping("/changePwd")
    public String changePwd(@RequestParam("nowPwd") String nowPwd,
                            @RequestParam("newPwd") String newPwd,
                            @RequestParam("confirmPwd") String confirmPwd,
                            Model model) {

        Subject subject = SecurityUtils.getSubject();
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Users u = userService.queryUsersById(user.getUserId());

        model.addAttribute("user", u);

        if (user.getUserPwd().equals(nowPwd))
        {
            if (newPwd.equals(confirmPwd))
            {
                Integer i = userService.updateUser(new Users(user.getUserId(), user.getZId(), user.getUserName(), newPwd, user.getPhone(), user.getEmail(),
                        user.getDepartment(), user.getAddress(), user.getAuth()));

                subject.logout();

                model.addAttribute("changeSuccess","Password changed, logout!");

                return "login";

            }
            else {
                model.addAttribute("fail", "Different new passwords!");
            }
        }
        else {
            model.addAttribute("fail", "Invalid password!");
        }




        return "changePwd";
    }


    @RequestMapping("/profile")
    public String profile(Model model) {

        Subject subject = SecurityUtils.getSubject();
        Users user = (Users) SecurityUtils.getSubject().getPrincipal();

        Users u = userService.queryUsersById(user.getUserId());

        model.addAttribute("user", u);


        return "profile";
    }




    @RequestMapping("/changeProfile")
    public String changeProfile(@RequestParam(required = false,name = "phone",defaultValue = "-1") Integer phone,
                                @RequestParam(required = false,name = "email", defaultValue = "-1") String email,
                                @RequestParam(required = false,name = "address", defaultValue = "-1") String address,
                            Model model) {

        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
        Users u = userService.queryUsersById(user.getUserId());

        if (phone == -1 && email.equals("-1") && address.equals("-1") )
        {
            model.addAttribute("msg", "Failed, all empty!");
            model.addAttribute("user", u);
            return "profile";
        }
        if (!address.equals("-1")){
            user.setAddress(address);
            Integer i = userService.updateUser(new Users(user.getUserId(), user.getZId(), user.getUserName(), user.getUserPwd(), user.getPhone(), user.getEmail(),
                    user.getDepartment(), address, user.getAuth()));
        }
        if (phone != -1){
            user.setPhone(phone);
            Integer i = userService.updateUser(new Users(user.getUserId(), user.getZId(), user.getUserName(), user.getUserPwd(), phone, user.getEmail(),
                    user.getDepartment(), user.getAddress(), user.getAuth()));
        }
        if(!email.equals("-1")) {
            user.setEmail(email);
            Integer i = userService.updateUser(new Users(user.getUserId(), user.getZId(), user.getUserName(), user.getUserPwd(), user.getPhone(), email,
                    user.getDepartment(), user.getAddress(), user.getAuth()));
        }

        u = userService.queryUsersById(user.getUserId());


        model.addAttribute("user", u);

        model.addAttribute("success", "Success!");



        return "profile";
    }
}
