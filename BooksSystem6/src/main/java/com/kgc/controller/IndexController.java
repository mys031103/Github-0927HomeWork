package com.kgc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.BookInfo;
import com.kgc.entity.Users;
import com.kgc.service.BookInfoService;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    UsersService usersService;
    @Resource
    BookInfoService bookInfoService;
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String userCode, String password, Model model, HttpSession session){
        Users login = usersService.login(userCode);
        if(login==null){
            model.addAttribute("flag",false);
            return "login";
        }else if(login.getPassword().equals(password)==false){
            model.addAttribute("flag",false);
            return "login";
        }
        session.setAttribute("user",login);
        return "redirect:/index";
    }
    @RequestMapping("/tuichu")
    public String tuichu(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/index")
    public String index(String pageNumStr,String bookType, String title, String isBorrow, Model model){
        int pageSize=5;
        int pageNum=1;
        if(pageNumStr!=null){
            pageNum=Integer.parseInt(pageNumStr);
        }
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("creation_time desc");
        List<BookInfo> bookInfos = bookInfoService.selectAll(bookType, title, isBorrow);
        PageInfo<BookInfo>PageInfo=new PageInfo<>(bookInfos);
        model.addAttribute("PageInfo",PageInfo);
        return "index";
    }
}
