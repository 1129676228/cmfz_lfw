package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void updatepwd(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public void register(Admin admin) {
        admin.setId(UUID.randomUUID().toString());

        adminDao.save(admin);

    }

    @Override
    public Admin login(Admin admin) {
        Admin login = adminDao.queryAdmin(admin);
        if (login!=null){
            return  login;
        }else{
            return null;
        }

    }
}
