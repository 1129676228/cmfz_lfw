package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl  implements  UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.saveUser(user);
    }

    @Override
    public String login(User user) {
        User login = userDao.queryUser(user);
        if (login!=null){
            return  "100";
        }else{
            return "101";
        }

    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
