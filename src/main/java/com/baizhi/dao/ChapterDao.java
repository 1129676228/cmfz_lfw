package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    List<Chapter> queryAllchapter();

    void saveChapter(Chapter chapter);

    void updateChapter(Chapter chapter);

    void deleteChapter(String id);

}
