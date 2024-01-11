package com.research.service.impl;

import com.research.mapper.DataSetMapper;
import com.research.pojo.DataSet;
import com.research.service.DataSetService;
import com.research.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

}
