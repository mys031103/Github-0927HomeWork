package com.kgc.service;

import com.kgc.entity.BookInfo;


import java.util.List;

public interface BookInfoService {
    List<BookInfo>selectAll(String bookType, String bookName, String isBorrow);
}
