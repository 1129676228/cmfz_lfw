package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    void register(Admin admin);
    Admin login(Admin admin);

    void updatepwd(Admin admin);
}
