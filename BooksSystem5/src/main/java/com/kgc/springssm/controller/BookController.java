package com.kgc.springssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.springssm.pojo.Book_info;
import com.kgc.springssm.pojo.Users;
import com.kgc.springssm.service.Book_infoService;
import com.kgc.springssm.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 14:19
 */
@Controller
public class BookController {
    @Resource
    UsersService usersService;
    @Resource
    Book_infoService book_infoService;
    @RequestMapping("/")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/login")
    public String doindex(String userCode, String password, Model model, HttpSession session){
        Users users = usersService.login(userCode);
        if(users==null){
            model.addAttribute("flag",false);
            return "login";
        }else if(users.getPassword().equals(password)==false){
            model.addAttribute("flag",false);
            return "login";
        }
        session.setAttribute("users",users);
        return "redirect:/index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
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
        List<Book_info> bookInfos = book_infoService.selectAll(bookType, title, isBorrow);
        PageInfo<Book_info> PageInfo=new PageInfo<>(bookInfos);
        model.addAttribute("PageInfo",PageInfo);
        return "index";
    }
}
