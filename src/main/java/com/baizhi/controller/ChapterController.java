package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("findAllChap")
    public @ResponseBody List<Chapter> findAll(){
        List<Chapter> chap = chapterService.findAllChap();
        return chap;
    }


    @RequestMapping("/insertChap")
    public @ResponseBody
    Map<String,Object> insert(Chapter chapter, MultipartFile multipartFile, HttpServletRequest request){
       Map<String, Object> results = new HashMap<String, Object>();
       try {
           String file = FileUtil.saveFile(multipartFile, "/zhuanji/", request);
           chapter.setDownPath(file);
           Double size = FileUtil.AudioSize(chapter.getDownPath(), request);
           String length = FileUtil.AudioLength(chapter.getDownPath(), request);

           chapter.setSize(size);
           chapter.setDuration(length);

           chapterService.insertChap(chapter);

        results.put("success",true);
    } catch (Exception e) {
        e.printStackTrace();
        results.put("success",false);
        results.put("message",e.getMessage());
    }
        return results;
    }

    @RequestMapping("/updateChap")
    public @ResponseBody void update(Chapter chapter){
        chapterService.updateChap(chapter);
    }

    @RequestMapping("/deleteChap")
    public @ResponseBody void  delete(String id){
        chapterService.removeChap(id);
    }

    @RequestMapping("/download")
    public void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response)
            throws Exception{
        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath,fileName));
        //2.1设置响应头
        response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

}
