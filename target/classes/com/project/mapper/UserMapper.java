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

    int addUser(Users user);

    int updateUser(Users user);

    int deleteUser(int id);


}
