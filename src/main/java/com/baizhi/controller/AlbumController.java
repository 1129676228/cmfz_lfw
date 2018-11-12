package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAllAlbum")
    public @ResponseBody List<Album> findAllAlbum(){
        List<Album> album1 = albumService.findAllAlbum();
        return  album1;
    }

    @RequestMapping("/insertAlbum")
    public@ResponseBody Map<String,Object> saveAlbum(Album album, HttpServletRequest request, MultipartFile file) throws IOException {


        Map<String,Object> results = new HashMap<String,Object>();
        try {

            String realPath = request.getSession().getServletContext().getRealPath("zhuanji");
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            album.setcoverimg(file.getOriginalFilename());

            albumService.insertAlbum(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

   /* @RequestMapping("/deleteAlbum")
    public @ResponseBody void deleteAlbum(String id){
        albumService.deleteAlbum(id);
    }*/


    @RequestMapping("/findOneAlb")
    public @ResponseBody Album findOne(String id){
        Album oneAlb = albumService.findOneAlb(id);
        return  oneAlb;
    }

}
