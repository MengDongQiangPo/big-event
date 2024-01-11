package com.research.mapper;

import com.research.pojo.DataSet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DataSetMapper {
    //新增
    @Insert("insert into data_set(title,content,key_words,from_where,category_id,attachment,instruction,create_user,create_time,update_time) " +
            "values(#{title},#{content},#{keyWords},#{fromWhere},#{categoryId},#{attachment},#{instruction},#{createUser},#{createTime},#{updateTime})")
    void add(DataSet dataSet);


    List<DataSet> list(Integer userId, Integer categoryId);

    //根据关键词查询
    @Select("select * from data_set where id = (select data_set.id "+
            "from data_set join category on data_set.category_id = category.id " +
            "where title like concat('%',#{keyword},'%') or key_words like concat('%',#{keyword},'%') or category.category_name like concat('%',#{keyword},'%'))")
    List<DataSet> searchDataSets(String keyword);

    //更改
    @Update("update data_set set title=#{title},content=#{content},key_words=#{keyWords},from_where=#{fromWhere},category_id=#{categoryId}," +
            "attachment=#{attachment},instruction=#{instruction},create_user=#{createUser},update_time=#{updateTime} where id=#{id}")
    void update(DataSet dataSet);

    //删除
    @Delete("delete from data_set where id=#{id}")
    void deleteById(Integer id);
}
