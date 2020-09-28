package com.kgc.tcmp077.service;

import com.kgc.tcmp077.pojo.BookInfo;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-27 21:49
 */
public interface BookInfoService {
    List<BookInfo> bList(String bookType,String bookName,String isBorrow);
}
