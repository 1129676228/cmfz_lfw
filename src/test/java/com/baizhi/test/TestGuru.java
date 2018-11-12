package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGuru {

    @Autowired
    private GuruService guruService;
    @Test
    public void test1(){
        List<Guru> allGuru = guruService.findAllGuru();
        for (Guru guru : allGuru) {
            System.out.println(guru);
        }
    }
    @Test
    public void test2(){
        Guru guru = new Guru();

        guru.setName("xiaohei");
        guru.setHeadPic("/shangshitupian/3.jpg");
        guru.setSex("man");
        guruService.insertGuru(guru);
    }

    @Test
    public void test3(){

        guruService.removeGuru("d196883d-3b30-474d-8f76-b393a2308afc");

    }

    @Test
    public void test4(){
        Guru guru = new Guru();
        guru.setName("小黑");
        guru.setId("3");
        guruService.updateGuru(guru);
    }
}
