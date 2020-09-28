package com.kgc.tcmp077.wangyf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.tcmp077.wangyf.entity.Bookinfo;
import com.kgc.tcmp077.wangyf.entity.BookinfoExample;
import com.kgc.tcmp077.wangyf.mapper.BookinfoMapper;
import com.kgc.tcmp077.wangyf.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @author wangyf
 * @create 2020-09-27 22:27
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookinfoMapper bookinfoMapper;

    @Override
    public PageInfo<Bookinfo> getList(Integer type, String name, int borrow, int pageNum) {
        BookinfoExample bookinfoExample = new BookinfoExample();
        BookinfoExample.Criteria criteria = bookinfoExample.createCriteria();
        if(type!=0){
            criteria.andBookTypeEqualTo(type);
        }
        if(name.isEmpty()==false){
            criteria.andBookNameLike("%"+name+"%");
        }
        if(borrow==1||borrow==0){
            criteria.andIsBorrowEqualTo(borrow);
        }
        int  pageSize=3;
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("creation_Time desc");
        List<Bookinfo> bookinfos = bookinfoMapper.selectByExample(bookinfoExample);
        PageInfo<Bookinfo> pageInfo=new PageInfo<>(bookinfos);
        return pageInfo;
    }

    @Override
    public Bookinfo selectById(int id) {
        Bookinfo bookinfo = bookinfoMapper.selectByPrimaryKey(id);
        return bookinfo;
    }

    @Override
    public int updateBookinfo(Bookinfo bookinfo) {
        BookinfoExample bookinfoExample = new BookinfoExample();
        BookinfoExample.Criteria criteria = bookinfoExample.createCriteria();
        int i = bookinfoMapper.updateByPrimaryKeySelective(bookinfo);
        return i;
    }
}
