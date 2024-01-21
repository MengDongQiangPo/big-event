package com.research.controller;

import com.research.pojo.DataSet;
import com.research.pojo.PageBean;
import com.research.pojo.Result;
import com.research.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataSet")
public class DataSetController {

    @Autowired
    private DataSetService dataSetService;

    @PostMapping
    public Result add(@RequestBody @Validated DataSet dataSet) {
        dataSetService.add(dataSet);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<DataSet>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId
    ) {
        PageBean<DataSet> pb = dataSetService.list(pageNum,pageSize,categoryId);
        return Result.success(pb);
    }

    @GetMapping("/search")
    public Result<PageBean<DataSet>> searchDataSets(String keyword,  Integer pageNum, Integer pageSize) {
        PageBean<DataSet> pb = dataSetService.searchDataSets(keyword,pageNum,pageSize);
        return Result.success(pb);
    }

    @PutMapping
    public Result update(@RequestBody DataSet dataSet) {
        dataSetService.update(dataSet);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id) {
        dataSetService.deleteById(id);
        return Result.success();
    }
}
