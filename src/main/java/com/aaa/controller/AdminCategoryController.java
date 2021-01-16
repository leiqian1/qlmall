package com.aaa.controller;


import com.aaa.entity.Category;
import com.aaa.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/admin/category")
@Controller
public class AdminCategoryController {
    //定义业务层对象
    @Resource
    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "/admin/category_list";
    }
    @RequestMapping("/add_show")
    public String add_show(){
        return "/admin/category_add";
    }
    @RequestMapping("/add_submit")
    public String add_submit(Category category){
        categoryService.insert(category);

        return "redirect:/admin/category/list";
    }
    @RequestMapping("/update_show")
    public String update_show(Integer categoryId, Model model){
        Category category = categoryService.find(categoryId);
        model = model.addAttribute("category",category);
        return "/admin/category_update";
    }
    @RequestMapping("/update_submit")
    public String update_submit(Category category){
        categoryService.update(category);
        return "redirect:/admin/category/list";
    }
}
