package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBanner extends TestBasic{

    @Autowired
    private BannerService bannerService;
    @Test
    public void test11(){
        Banner banner = new Banner();
        banner.setId(6);
        banner.setTitle("藏区一脚");
        banner.setImgPath("d:/img/img/img");
        banner.setDescs("佛佛佛佛佛佛佛佛");
        banner.setStatus("yes");
        banner.setDate(new Date());
        bannerService.insert(banner);
    }


    @Test
    public void test22(){
        List<Banner> list = bannerService.findAllImg();
        for (Banner banner : list) {
            System.out.println(banner);
        }
        }

        @Test
    public void testOne(){
            Banner one = bannerService.findOne(2);
            System.out.println(one);

        }

        @Test
    public void testinsert(){
            Banner banner1 = new Banner();
            banner1.setId(6);
            banner1.setTitle("佛系");
            banner1.setImgPath("/dsadsadad");
            banner1.setDescs("fofofoffo");
            banner1.setStatus("no");
            banner1.setDate(new Date());
            bannerService.insert(banner1);

        }
}
