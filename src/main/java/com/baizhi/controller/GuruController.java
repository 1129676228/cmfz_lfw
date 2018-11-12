package com.baizhi.controller;


import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("/Guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("findAllGuru")
    public@ResponseBody
    List<Guru> findAllGuru(){
        List<Guru> guru = guruService.findAllGuru();
        return guru;
    }

    @RequestMapping("/insertGuru")
    public @ResponseBody Map<String,Object> insertGuru(Guru guru, HttpServletRequest request, MultipartFile file) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("shangshitupian");//文件上传路径
        file.transferTo(new File(path,file.getOriginalFilename()));
        guru.setHeadPic(file.getOriginalFilename());

        Map<String,Object> results = new HashMap<String, Object>();
        try {
            guruService.insertGuru(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/updateGuru")
    public @ResponseBody void updateGuru(Guru guru,HttpServletRequest request, MultipartFile file) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("shangshitupian");//文件上传路径
        file.transferTo(new File(path,file.getOriginalFilename()));
        guru.setHeadPic(file.getOriginalFilename());

        guruService.updateGuru(guru);
    }


    @RequestMapping("/deleteGuru")
    public @ResponseBody void deleteGuru(String id){
        guruService.removeGuru(id);
    }

    @RequestMapping("/findOneGuru")
    public@ResponseBody Guru findOne(String id){
        Guru guru = guruService.finOne(id);
        return guru;
    }
}
