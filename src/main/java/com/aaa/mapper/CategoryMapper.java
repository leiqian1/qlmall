package com.aaa.mapper;

import com.aaa.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    //查询所有
    List<Category> findAll();
    //根据Id查询
    Category find(Integer categoryId);
    //添加商品分类
    int doadd(Category category);
    //更新商品分类
    int doupdate(Category category);
}
