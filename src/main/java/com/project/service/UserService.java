package com.project.service;

import com.project.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> queryUsersList();

    Users queryUsersById(int id);

    Users queryUsersByEmail(String email);

    Users queryUsersByUsername(String userName);

    Users queryUsersByzId(Integer zId);

    Integer addUser(Users user);

    Integer updateUser(Users user);

    Integer deleteUser(int id);

    String getAuth(String email);

    String getLoginName(String email);

}
