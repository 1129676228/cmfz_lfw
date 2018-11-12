package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements  BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> findAllImg() {
        List<Banner> banners = bannerDao.queryAllImg();
        return banners;
    }

    @Override
    public Banner findOne(Integer id) {
        Banner banner = bannerDao.queryOne(id);
        return banner;
    }

    @Override
    public void update(Banner banner) {
        bannerDao.updateImg(banner);
    }

    @Override
    public void remove(Integer id) {
        bannerDao.deleteImg(id);
    }

    @Override
    public void insert(Banner banner) {
         bannerDao.saveImg(banner);
    }
}
