package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String title;
    private String iconCls;
    private String href;

    private List<Menu> children = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", children=" + children +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(Integer id, String title, String iconCls, String href, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.href = href;
        this.children = children;
    }

    public Menu() {
    }
}