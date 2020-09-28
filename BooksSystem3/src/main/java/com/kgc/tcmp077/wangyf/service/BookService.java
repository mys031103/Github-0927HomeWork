package com.kgc.tcmp077.wangyf.service;

import com.github.pagehelper.PageInfo;
import com.kgc.tcmp077.wangyf.entity.Bookinfo;

/**
 * @author wangyf
 * @create 2020-09-27 22:25
 */
public interface BookService {
    PageInfo<Bookinfo> getList(Integer type,String name,int  borrow,int pageNum );
    Bookinfo selectById(int id);
    //修改
    int updateBookinfo(Bookinfo bookinfo);
}
