package com.research.controller;

import com.research.pojo.Article;
import com.research.pojo.PageBean;
import com.research.pojo.Result;
import com.research.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
       PageBean<Article> pb =  articleService.list(pageNum,pageSize,categoryId,state);
       return Result.success(pb);
    }

    @GetMapping("/search")
    public Result<PageBean<Article>> searchArticles( String keyword, Integer pageNum, Integer pageSize) {
        PageBean<Article> pb = articleService.searchArticles(keyword,pageNum,pageSize);
        return Result.success(pb);
    }

    @PutMapping
    public Result update(@RequestBody Article article) {
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id) {
        articleService.deleteById(id);
        return Result.success();
    }
}
