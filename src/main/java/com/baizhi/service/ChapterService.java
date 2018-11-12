package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> findAllChap();

    void insertChap(Chapter chapter);

    void updateChap(Chapter chapter);

    void removeChap(String id);
}
