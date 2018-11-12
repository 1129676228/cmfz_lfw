package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements  GuruService {

    @Autowired
    private GuruDao guruDao;
    @Override
    public List<Guru> findAllGuru() {
        List<Guru> gurus = guruDao.queryAllGuru();
        return gurus;
    }

    @Override
    public Guru finOne(String id) {
        Guru guru = guruDao.queryOne(id);
        return guru;
    }

    @Override
    public void insertGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.saveGuru(guru);
    }

    @Override
    public void removeGuru(String id) {
            guruDao.deleteGuru(id);
    }

    @Override
    public void updateGuru(Guru guru) {
        guruDao.updateGuru(guru);
    }
}
