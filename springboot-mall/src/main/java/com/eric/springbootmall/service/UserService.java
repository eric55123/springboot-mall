package com.eric.springbootmall.service;

import com.eric.springbootmall.dto.UserRegisterRequest;
import com.eric.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

}
