package com.project.service;

import com.project.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> queryUsersList();

    Users queryUsersById(int id);

    Users queryUsersByEmail(String email);

    int addUser(Users user);

    int updateUser(Users user);

    int deleteUser(int id);

    String getAuth(String email);

    String getLoginName(String email);

}
