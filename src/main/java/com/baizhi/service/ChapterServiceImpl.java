package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService{
    @Autowired

    private ChapterDao chapterDao;

    @Override
    public List<Chapter> findAllChap() {
        List<Chapter> chapters = chapterDao.queryAllchapter();
        return chapters;
    }

    @Override
    public void insertChap(Chapter chapter) {

        chapter.setId(UUID.randomUUID().toString());
        chapterDao.saveChapter(chapter);
    }

    @Override
    public void updateChap(Chapter chapter) {
        chapterDao.updateChapter(chapter);
    }

    @Override
    public void removeChap(String id) {
        chapterDao.deleteChapter(id);
    }
}
