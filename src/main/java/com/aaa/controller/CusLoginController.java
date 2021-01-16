package com.aaa.controller;

import com.aaa.entity.Customers;
import com.aaa.service.ICustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CusLoginController {
    @Resource
    ICustomersService customersService;
    @RequestMapping("/login_show")
    public String login_show(){
        return "customer/login";
    }
    @RequestMapping("/login_submit")
    public String login_submit(Customers customers, HttpSession httpSession, Model model){
        ICustomersService iCustomersService;
        Customers c = customersService.customerslogin(customers);
        if(c==null){
            model.addAttribute("err","用户名或密码不正确");
            return "/customer/login";
        }
        String name = customers.getName();
        //获取登陆者名字
        httpSession.setAttribute("customers",c);
        return "redirect:/";
    }
}
