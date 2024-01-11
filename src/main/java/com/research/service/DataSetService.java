package com.research.service;

import com.research.pojo.DataSet;
import com.research.pojo.PageBean;

import java.util.List;

public interface DataSetService {
    //新增数据集
    void add(DataSet dataSet);

    //条件分页列表查询
    PageBean<DataSet> list(Integer pageNum, Integer pageSize, Integer categoryId);

    //关键字检索
    List<DataSet> searchDataSets(String keyword);

    //更改数据集信息
    void update(DataSet dataSet);

    //删除数据集描述
    void deleteById(Integer id);
}
