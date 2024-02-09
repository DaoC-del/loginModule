package com.server.loginmodule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.loginmodule.mapper.UserMapper;
import com.server.loginmodule.model.User;
import com.server.loginmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user); // 使用MP的insert方法
    }

    @Override
    public boolean validateUser(String username, String password) {
        // 这里假设username是唯一的
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}
