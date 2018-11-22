package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> findAll();

    User selectById(int id);

    void updateById(User user);

    void deleteById(int id);
}
