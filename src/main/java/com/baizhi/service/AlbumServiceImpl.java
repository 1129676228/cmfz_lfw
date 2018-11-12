package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> findAllAlbum() {
        List<Album> albums = albumDao.queryAllAlbum();
        return albums;
    }

    @Override
    public Album findOneAlb(String id) {
        Album album = albumDao.queryOneAlbum(id);
        return album;
    }

    @Override
    public void insertAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.saveAlbum(album);
    }

   /* @Override
    public void deleteAlbum(String id) {
        albumDao.deleteAlbum(id);
    }*/
}
