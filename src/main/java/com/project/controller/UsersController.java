package com.project.controller;


import com.project.mapper.UserMapper;
import com.project.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUsersList")
    public List<Users> queryUsersList()
    {
        List<Users> usersList = userMapper.queryUsersList();

        for (Users user : usersList)
        {
            System.out.println(user);
        }

        return usersList;
    }

    @GetMapping("/queryUsers")
    public Users queryUsersById()
    {
        Users users = userMapper.queryUsersById(2);

        System.out.println(users);

        return users;
    }

    @GetMapping("/addUsers")
    public String addUsers(){
        userMapper.addUser(new Users(null, 5333333, "XYZ", "123456", 400444444, "9900@gmail.com", "Law", "Library","1"));
        return "addOk";
    }


    @GetMapping("/updateUsers")
    public String updateUsers(){
        userMapper.updateUser(new Users(4, 5333334, "XYZ", "123456", 400444444, "9900@gmail.com", "Law", "Library","1"));
        return "updateOk";
    }

    @GetMapping("/deleteUsers")
    public String deleteUsers(){
        userMapper.deleteUser(5);
        return "deleteOk";
    }
}
