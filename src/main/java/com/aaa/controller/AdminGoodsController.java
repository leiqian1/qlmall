package com.aaa.controller;

import com.aaa.entity.Category;
import com.aaa.entity.Goods;
import com.aaa.service.ICategoryService;
import com.aaa.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/goods")
@Controller
public class AdminGoodsController {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private IGoodsService goodsService;
    @RequestMapping("/list")
    public String list(Model model){
        List<Goods> goodsList = goodsService.list();
        model.addAttribute("goodsList",goodsList);
        return "/admin/goods_list";
    }
    @RequestMapping("/add_show")
    public String add_show(Model model){
        List<Category> categoryList=categoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "/admin/goods_add";
    }
    @RequestMapping("/add_submit")
    public String add_submit(Goods goods, MultipartFile file){
        String imgFile=null;
        if(file.isEmpty()){
            //没有上传用默认图片
            imgFile = "/img/mr.jpg";
        }else{
            //生成新的文件名
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            //使用新的文件名构建文件对象
            File f = new File("C:/Users/qianl/IdeaProjects/qlmall/picture",newFile);

            if(!f.getParentFile().exists()){
                f.mkdirs();
            }
            try {
                file.transferTo(f);
                imgFile="/upfile/"+newFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //设置goods对象的图片格式
        goods.setPicture(imgFile);
        goodsService.insert(goods);

        return "redirect:/admin/goods/list";
    }

    @RequestMapping("/update_show")
    public String update_show(Integer goodsId,Model model){
        //根据编号获取商品信息
        Goods goods = goodsService.find(goodsId);
        //查询分类数据
        List<Category> categoryList = categoryService.list();
        model.addAttribute("goods",goods);
        model.addAttribute("categoryList",categoryList);
        return "/admin/goods_update";
    }
    @RequestMapping("/update_submit")
    public String update_submit(Goods goods, MultipartFile file){
        String imgFile=null;
        if(!file.isEmpty()){
            //生成新的文件名
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            //使用新的文件名构建文件对象
            File f = new File("C:/Users/qianl/IdeaProjects/qlmall/picture",newFile);

            if(!f.getParentFile().exists()){
                f.mkdirs();
            }
            try {
                file.transferTo(f);
                goods.setPicture("/upfile/"+newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        goodsService.update(goods);

        return "redirect:/admin/goods/list";
    }

}
