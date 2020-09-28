package com.kgc.tcmp077.wangyf.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.tcmp077.wangyf.entity.Bookinfo;
import com.kgc.tcmp077.wangyf.service.BookService;
import org.omg.CORBA.TypeCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyf
 * @create 2020-09-27 22:36
 */
@Controller
public class BookController {
    @Resource
    BookService BookService;

    @RequestMapping("/selectByTypeAndName")
    public String selectByTypeAndName(@RequestParam(value = "bookType", defaultValue = "0", required = false) int bookType,
                                      @RequestParam(value = "bookName", defaultValue = "", required = false) String bookName,
                                      @RequestParam(value = "isBorrow", defaultValue = "3", required = false) int isBorrow,
                                      @RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex, Model model) {
        PageInfo<Bookinfo> list = BookService.getList(bookType, bookName, isBorrow, pageIndex);
        model.addAttribute("pageInfo",list);
        model.addAttribute("bookType",bookType);
        model.addAttribute("bookName",bookName);
        model.addAttribute("isBorrow",isBorrow);
        return "index";
    }
    @RequestMapping("/setIsBorrowZero/{id}")
    @ResponseBody
    public Map<String,Object> setIsBorrowZero(@PathVariable("id") Integer id){
        Bookinfo bookinfo = BookService.selectById(id);
        Map<String,Object> map=new HashMap<>();
        if(bookinfo==null){
           map.put("result","false");
           //map.put("msg","归还图书失败");
        }else{
            bookinfo.setIsBorrow(0);
            int i = BookService.updateBookinfo(bookinfo);
            map.put("result","true");

        }
        return map;
    }
    @RequestMapping("/setIsborrowOne/{id}")
    @ResponseBody
    public Map<String, Object> setIsborrowOne(@PathVariable("id") int id){
        Bookinfo bookinfo = BookService.selectById(id);
        Map<String,Object> map=new HashMap<>();
        if(bookinfo==null){
            map.put("result","false");
            //map.put("msg","归还图书失败");
        }else{
            bookinfo.setIsBorrow(1);
            int i = BookService.updateBookinfo(bookinfo);
            map.put("result","true");
        }
        return map;
    }
}
