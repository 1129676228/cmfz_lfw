package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> findAllImg();

    void insert(Banner banner);

    void remove(Integer id);

    void update(Banner banner);

    Banner findOne(Integer id);

}
