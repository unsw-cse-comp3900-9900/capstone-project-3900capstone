package com.project.mapper;

import com.project.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<Users> queryUsersList();

    Users queryUsersById(int id);

    Users queryUsersByEmail(String email);

    Users queryUsersByUsername(String userName);

    Users queryUsersByzId(Integer zId);

    Integer addUser(Users user);

    Integer updateUser(Users user);

    Integer deleteUser(int id);


}
