package com.aaa.service;

import com.aaa.entity.Category;

import java.util.List;

public interface ICategoryService {
    //查询所有分类
    List<Category> list();
    //添加所有分类
    int insert(Category category);
    //根据id查找分类
    Category find(Integer categoryId);
    //更新分类
    int update(Category category);
}
