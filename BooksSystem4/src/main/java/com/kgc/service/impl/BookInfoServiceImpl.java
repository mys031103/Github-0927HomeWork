package com.kgc.service.impl;

import com.kgc.mapper.BookInfoMapper;
import com.kgc.pojo.BookInfo;
import com.kgc.pojo.BookInfoExample;
import com.kgc.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService{
    @Resource
    BookInfoMapper bookInfoMapper;
    @Override
    public List<BookInfo> selectAll(String bookType, String bookName, String isBorrow) {
        BookInfoExample example=new BookInfoExample();
        BookInfoExample.Criteria criteria = example.createCriteria();
        if(bookType!=null&&bookType.equals("0")==false){
            criteria.andBookTypeEqualTo(Integer.parseInt(bookType));
        }else if(bookName!=null&&bookName.isEmpty()==false){
            criteria.andBookNameLike("%"+bookName+"%");
        }else if(isBorrow!=null&&isBorrow.equals("2")==false){
            criteria.andIsBorrowEqualTo(Integer.parseInt(isBorrow));
        }else{
            return bookInfoMapper.selectByExample(null);
        }
        return bookInfoMapper.selectByExample(example);
    }
}
