package com.eric.springbootmall.service.impl;


import com.eric.springbootmall.dao.UserDao;
import com.eric.springbootmall.dto.UserLoginRequest;
import com.eric.springbootmall.dto.UserRegisterRequest;
import com.eric.springbootmall.model.User;
import com.eric.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊 email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null) {
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
//        // 使用 MD5 生成密碼雜湊值
//        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
//        userRegisterRequest.setPassword(hashedPassword);

        // 使用 bcrypt 生成密碼雜湊值
        String hashPassword = passwordEncoder.encode(userRegisterRequest.getPassword());
        userRegisterRequest.setPassword(hashPassword);

        // 創建帳號
        return userDao.createUser(userRegisterRequest);

    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        // 檢查 user 是否存在
        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

//        // 使用 MD5 升成雜湊值
//        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        // 比較密碼
        if (passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}

















