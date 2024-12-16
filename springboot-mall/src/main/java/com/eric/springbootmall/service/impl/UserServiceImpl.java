package com.eric.springbootmall.service.impl;


import com.eric.springbootmall.dao.UserDao;
import com.eric.springbootmall.dto.UserRegisterRequest;
import com.eric.springbootmall.model.User;
import com.eric.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
