package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
    void save(Admin admin);
    Admin queryAdmin(Admin admin);

    void update(Admin admin);
}
