package com.research.mapper;

import com.research.pojo.DataSet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataSetMapper {
    //新增
    @Insert("insert into data_set(title,content,key_words,from_where,category_id,attachment,instruction,create_user,create_time,update_time) " +
            "values(#{title},#{content},#{keyWords},#{fromWhere},#{categoryId},#{attachment},#{instruction},#{createUser},#{createTime},#{updateTime})")
    void add(DataSet dataSet);
}
