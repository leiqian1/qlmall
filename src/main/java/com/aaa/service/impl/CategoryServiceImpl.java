package com.aaa.service.impl;

import com.aaa.entity.Category;
import com.aaa.mapper.CategoryMapper;
import com.aaa.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    //mapper对象 完成数据库的访问操作
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list(){ return categoryMapper.findAll();
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.doadd(category);
    }

    @Override
    public Category find(Integer categoryId) {
        return categoryMapper.find(categoryId);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.doupdate(category);
    }
}
