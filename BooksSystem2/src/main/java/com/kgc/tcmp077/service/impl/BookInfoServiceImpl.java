package com.kgc.tcmp077.service.impl;

import com.kgc.tcmp077.mapper.BookInfoMapper;
import com.kgc.tcmp077.pojo.BookInfo;
import com.kgc.tcmp077.pojo.BookInfoExample;
import com.kgc.tcmp077.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-27 21:51
 */
@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> bList(String bookType, String bookName, String isBorrow) {
        BookInfoExample bookInfoExample=new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        if(bookType!=null&&bookType.equals("0")==false){
            criteria.andBookTypeEqualTo(Integer.parseInt(bookType));
        }else if(bookName!=null&&bookName.isEmpty()==false){
            criteria.andBookNameLike("%"+bookName+"%");
        }else if(isBorrow!=null&&isBorrow.equals("2")==false){
            criteria.andIsBorrowEqualTo(Integer.parseInt(isBorrow));
        }else{
            return bookInfoMapper.selectByExample(null);
        }
        return bookInfoMapper.selectByExample(bookInfoExample);
    }
}
