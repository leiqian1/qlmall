package com.aaa.controller;

import com.aaa.entity.Users;
import com.aaa.service.IUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminLoginController {
    //定义后台用户业务对象
    @Resource
    private IUsersService usersService;

    @RequestMapping("/login_show")
    public String login_show(){
        return "/admin/login";
    }
    @RequestMapping("/login_submit")
    public String login_submit(Users users, HttpSession session, Model model){
        //登录校验
        Users u = usersService.adminLogin(users);
        if(u==null){
            model.addAttribute("err","用户名或密码不正确");
            return "/admin/login";
        }
        //将登录的账号存入session,用于绘画跟踪
        session.setAttribute("adminUser",u);
        return "/admin/index";
    }
}
