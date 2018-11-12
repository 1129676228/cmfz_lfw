package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> queryAllAlbum();

    void saveAlbum(Album album);

    //void   deleteAlbum(String id);

    Album queryOneAlbum(String id);

}
