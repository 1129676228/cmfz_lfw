package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {


    @Autowired
    private BannerService bannerService;
    @RequestMapping("/findAll")
    public @ResponseBody   List<Banner> findAllImg(){
        List<Banner> list = bannerService.findAllImg();
        return list;
    }

    @RequestMapping("/insert")
    public @ResponseBody
    Map<String,Object> save(Banner banner,HttpServletRequest request,MultipartFile file ) throws IOException {


        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String path = request.getSession().getServletContext().getRealPath("lunbotupian");//文件上传路径
            file.transferTo(new File(path,file.getOriginalFilename()));
            banner.setImgPath(file.getOriginalFilename());


            bannerService.insert(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/delete")
    public @ResponseBody void delete(Integer id){
        bannerService.remove(id);
    }


    @RequestMapping("/update")
    public @ResponseBody void update(Banner banner, HttpServletRequest request, MultipartFile file)throws Exception {
        String path = request.getSession().getServletContext().getRealPath("lunbotupian");//文件上传路径
        file.transferTo(new File(path,file.getOriginalFilename()));
        banner.setImgPath(file.getOriginalFilename());

        bannerService.update(banner);
    }

    @RequestMapping("/findOne")
    public @ResponseBody Banner findOne(Integer id){
        Banner findone = bannerService.findOne(id);
        return findone;
    }
}
