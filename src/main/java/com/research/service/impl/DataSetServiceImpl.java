package com.research.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.research.mapper.DataSetMapper;
import com.research.pojo.DataSet;
import com.research.pojo.PageBean;
import com.research.service.DataSetService;
import com.research.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class DataSetServiceImpl implements DataSetService {

    @Autowired
    private DataSetMapper dataSetMapper;

    @Override
    public void add(DataSet dataSet) {
        //补充属性值
        dataSet.setCreateTime(LocalDateTime.now());
        dataSet.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        dataSet.setCreateUser(userId);

        dataSetMapper.add(dataSet);
    }

    @Override
    public PageBean<DataSet> list(Integer pageNum, Integer pageSize, Integer categoryId) {
        //1.创建PageBean对象
        PageBean<DataSet> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //3.调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<DataSet> as = dataSetMapper.list(userId,categoryId);
        //Page中提供了方法,可以获取PageHelper分页查询后 得到的总记录条数和当前页数据
        Page<DataSet> p = (Page<DataSet>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public List<DataSet> searchDataSets(String keyword) {
        return dataSetMapper.searchDataSets(keyword);
    }

    @Override
    public void update(DataSet dataSet) {
        dataSet.setUpdateTime(LocalDateTime.now());
        dataSetMapper.update(dataSet);
    }

    @Override
    public void deleteById(Integer id) {
        dataSetMapper.deleteById(id);
    }
}
