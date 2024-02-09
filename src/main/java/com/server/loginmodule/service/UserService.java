package com.server.loginmodule.service;

import com.server.loginmodule.model.User;

public interface UserService {
    void registerUser(User user);
    boolean validateUser(String username, String password);
}
