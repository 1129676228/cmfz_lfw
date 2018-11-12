package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    void register(User user);
    String login(User user);
    void updateUser(User user);
}
