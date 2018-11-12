package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAlbum {
    @Autowired
    private AlbumService albumService;

    @Test
    public void testinsert(){
        Album album = new Album();
        album.setId("1");
        album.setTitle("甘露明珠");
        album.setPublishDate(new Date());
        album.setCount(30);
        album.setcoverimg("baizhi");
        album.setStar("五星");
        album.setAuthor("xiaohei");
        album.setBroadCast("xiaohei");
        album.setBrief("好书");
        albumService.insertAlbum(album);
    }
    @Test
    public void testQuery(){
        List<Album> allAlbum = albumService.findAllAlbum();
        for (Album album : allAlbum) {
            System.out.println(album);
        }
    }
}
