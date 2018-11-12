package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMenu extends  TestBasic{
    @Autowired
    private MenuService menuService;
    @Test
    public void test01(){
        List<Menu> menus = menuService.showAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
