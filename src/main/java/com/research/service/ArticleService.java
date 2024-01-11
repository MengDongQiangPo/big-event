package com.research.service;

import com.research.pojo.Article;
import com.research.pojo.PageBean;

import java.util.List;

public interface ArticleService {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //关键字检索
    List<Article> searchArticles(String keyword);

    //更改算法信息
    void update(Article article);

    //删除算法描述
    void deleteById(Integer id);
}
