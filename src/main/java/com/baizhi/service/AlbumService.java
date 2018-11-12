package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAllAlbum();

    void insertAlbum(Album album);

    //void deleteAlbum(String id);

    Album findOneAlb(String id);
}
