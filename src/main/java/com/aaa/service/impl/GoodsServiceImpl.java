package com.aaa.service.impl;

import com.aaa.entity.Goods;
import com.aaa.mapper.GoodsMapper;
import com.aaa.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> list() {
        return goodsMapper.findAll();
    }

    @Override
    public Goods find(Integer goodsId) {
        return goodsMapper.find(goodsId);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.doadd(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.doupdate(goods);
    }

    @Override
    public List<Goods> findRandLimit(Integer size) {
        return goodsMapper.findRandLimit(size);
    }

    @Override
    public List<Goods> findByCategory(Integer categoryId) {
        return goodsMapper.findByCategory(categoryId);
    }
}
