package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    void saveUser(User user);
    User queryUser(User user);
    void updateUser(User user);

}
