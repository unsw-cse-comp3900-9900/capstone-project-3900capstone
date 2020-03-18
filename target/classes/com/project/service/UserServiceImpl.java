package com.project.service;

import com.project.mapper.UserMapper;
import com.project.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<Users> queryUsersList() {
        return userMapper.queryUsersList();
    }

    @Override
    public Users queryUsersById(int id) {
        return userMapper.queryUsersById(id);
    }

    @Override
    public Users queryUsersByEmail(String email) {
        return userMapper.queryUsersByEmail(email);
    }

    @Override
    public int addUser(Users user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(Users user) {
         return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public String getAuth(String email) {
        return userMapper.queryUsersByEmail(email).getAuth();
    }

    @Override
    public String getLoginName(String email) {
        return userMapper.queryUsersByEmail(email).getEmail();
    }
}
