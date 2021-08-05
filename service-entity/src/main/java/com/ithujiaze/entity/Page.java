package com.ithujiaze.entity;

import lombok.Data;
import lombok.Getter;

@Data
public class Page {
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize=8;
    //当前页的数量
    private int size;
    //总记录数
    private long total;
    //总页数
    private int pages;
    public static Page ok() {
        Page page=new Page();
        page.setPageNum(8);
        return page;
    }
}
