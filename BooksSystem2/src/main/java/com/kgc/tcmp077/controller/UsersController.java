package com.kgc.tcmp077.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.tcmp077.pojo.BookInfo;
import com.kgc.tcmp077.pojo.Users;
import com.kgc.tcmp077.service.BookInfoService;
import com.kgc.tcmp077.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-27 21:30
 */
@Controller
public class UsersController {
    @Resource
    UsersService usersService;
    @Resource
    BookInfoService bookInfoService;
    @RequestMapping("/")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/login")
    public String dologin(String userCode, String password, HttpSession session,Model model){
        Users users = usersService.users(userCode);
        if(users==null||users.getPassword().equals(password)==false){
            model.addAttribute("flag",false);
            return "login";
        }else if(users.getPassword().equals(password)==false){
            model.addAttribute("flag",false);
            return "login";
        }
        session.setAttribute("user",users);
        return "redirect:/index";

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
        List<BookInfo> bookInfos = bookInfoService.bList(bookType, title, isBorrow);
        PageInfo<BookInfo>PageInfo=new PageInfo<>(bookInfos);
        model.addAttribute("PageInfo",PageInfo);
        return "index";
    }

}
