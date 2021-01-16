package com.aaa.service;

import com.aaa.entity.Goods;

import java.util.List;

public interface IGoodsService {
    List<Goods> list();
    Goods find(Integer goodsId);
    int insert(Goods goods);
    int update(Goods goods);

    List<Goods> findRandLimit(Integer size);

    List<Goods> findByCategory(Integer categoryId);

}
