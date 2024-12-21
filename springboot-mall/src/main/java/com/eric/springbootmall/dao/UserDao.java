package com.eric.springbootmall.dao;

import com.eric.springbootmall.dto.UserRegisterRequest;
import com.eric.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
