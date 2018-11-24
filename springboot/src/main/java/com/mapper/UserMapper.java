package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user);

    List<User> selectAll();

    User selectById(int id);

    void updateById(User user);

    void deleteById(int id);
}
