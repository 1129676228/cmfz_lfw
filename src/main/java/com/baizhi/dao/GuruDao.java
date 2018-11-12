package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDao {
    List<Guru> queryAllGuru();

    void saveGuru(Guru guru);

    void deleteGuru(String id);

    void updateGuru(Guru guru);

    Guru queryOne(String id);



}
