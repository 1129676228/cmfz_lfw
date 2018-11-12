package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDao {
    List<Banner> queryAllImg();

    void saveImg(Banner banner);

    void deleteImg(Integer id);

    void updateImg(Banner banner);

    Banner queryOne(Integer id);


}
