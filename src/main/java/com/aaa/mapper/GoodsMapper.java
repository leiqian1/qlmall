package com.aaa.mapper;

import com.aaa.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import sun.rmi.server.InactiveGroupException;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> findAll();
    Goods find(Integer goodsId);
    int doadd(Goods goods);
    int doupdate(Goods goods);
    //选8个
    List<Goods> findRandLimit(Integer size);
    List<Goods> findByCategory(Integer categoryId);
}
