package com.dao_jpa;

import com.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepositoryByName extends Repository<User, Integer> {
    List<User> findByName(String name);
}
