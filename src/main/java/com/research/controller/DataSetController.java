package com.research.controller;

import com.research.pojo.DataSet;
import com.research.pojo.Result;
import com.research.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
