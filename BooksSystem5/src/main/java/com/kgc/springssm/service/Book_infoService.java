package com.kgc.springssm.service;

import com.kgc.springssm.pojo.Book_info;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 13:54
 */
public interface Book_infoService {
    List<Book_info> selectAll(String bookType, String bookName, String isBorrow);
}
