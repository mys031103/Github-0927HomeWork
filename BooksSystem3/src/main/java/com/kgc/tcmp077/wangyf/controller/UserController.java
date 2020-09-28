package com.kgc.tcmp077.wangyf.controller;

import com.kgc.tcmp077.wangyf.entity.Users;
import com.kgc.tcmp077.wangyf.entity.UsersExample;
import com.kgc.tcmp077.wangyf.mapper.UsersMapper;
import com.kgc.tcmp077.wangyf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wangyf
 * @create 2020-09-27 22:04
 */
@Controller
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String toLogin(String userCode, String password , Model model, HttpSession session){
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if(userCode!=null){
            UsersExample.Criteria criteria1 = criteria.andPasswordEqualTo(userCode);
        }
        List<Users> users = userService.selectByUserCode(userCode);
        if(users==null){
            return "login";
        }else if(users.get(0).getPassword().equals(password)==false){
            return "login";
        }else{
            session.setAttribute("userName",users.get(0).getUserCode());
            return "redirect:selectByTypeAndName";
        }

    }
    @RequestMapping("/tuichu")
    public String totuichu(HttpSession session){
        session.invalidate();
        return "login";
    }
}
