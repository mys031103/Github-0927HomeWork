package com.kgc.springssm.service.impl;

import com.kgc.springssm.mapper.Book_infoMapper;
import com.kgc.springssm.pojo.Book_info;
import com.kgc.springssm.pojo.Book_infoExample;
import com.kgc.springssm.service.Book_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 13:55
 */
@Service
public class Book_infoServiceImpl implements Book_infoService{
    @Resource
    Book_infoMapper book_infoMapper;
    @Override
    public List<Book_info> selectAll(String bookType, String bookName, String isBorrow) {
        Book_infoExample example=new Book_infoExample();
        Book_infoExample.Criteria criteria = example.createCriteria();
        if(bookType!=null&&bookType.equals(0)==false){
            criteria.andBookTypeEqualTo(Integer.parseInt(bookType));
        }else if (bookName!=null&&bookName.isEmpty()==false){
            criteria.andBookNameLike("%"+bookName+"%");
        }else if(isBorrow!=null&&isBorrow.equals("2")==false){
            criteria.andIsBorrowEqualTo(Integer.parseInt(isBorrow));
        }else {
            return book_infoMapper.selectByExample(null);
        }
        return book_infoMapper.selectByExample(example);
    }
}
