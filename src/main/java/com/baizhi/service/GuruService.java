package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> findAllGuru();

    void insertGuru(Guru guru);

    void removeGuru(String id);

    void updateGuru(Guru guru);

    Guru finOne(String id);
}
