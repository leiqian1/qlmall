package com.aaa.controller;

import com.aaa.entity.Category;
import com.aaa.entity.Goods;
import com.aaa.service.ICategoryService;
import com.aaa.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FrontHomeController {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private IGoodsService goodsService;
    @RequestMapping("/")
    public String index(Model model){
        //获取商品分类
        List<Category> categoryList= categoryService.list();
        //获取8个商品显示在首页
        List<Goods> goodsList = goodsService.list();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("goodsList",goodsList);
        return "/front/index";

//        return "欢迎访问<br/><a href='/admin/login_show'>访问后台</a>";
    }
    @RequestMapping("/second")
    public String second(Integer categoryId, Model model){
        List<Category> categoryList = categoryService.list();
        List<Goods> goodsList = goodsService.findByCategory(categoryId);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("categoryId",categoryId);
        return "/front/second";
    }


}
