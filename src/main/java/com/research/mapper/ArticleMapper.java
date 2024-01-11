package com.research.mapper;

import com.research.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    //新增
    @Insert("insert into article(title,from_where,key_words,category_id,content,instruction,example_data_set,example_query,state,create_user,create_time,update_time) " +
            "values(#{title},#{fromWhere},#{keyWords},#{categoryId},#{content},#{instruction},#{exampleDataSet},#{exampleQuery},#{state},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);


    List<Article> list(Integer userId, Integer categoryId, String state);

    //根据关键词查询
    @Select("select * from article where id = (select article.id "+
            "from article join category on article.category_id = category.id " +
            "where title like concat('%',#{keyword},'%') or key_words like concat('%',#{keyword},'%') or category.category_name like concat('%',#{keyword},'%'))")
    List<Article> searchArticles(String keyword);

    //更改
    @Update("update article set title=#{title},from_where=#{fromWhere},key_words=#{keyWords},category_id=#{categoryId}," +
            "content=#{content},instruction=#{instruction},example_data_set=#{exampleDataSet},example_query=#{exampleQuery}," +
            "state = #{state},create_user=#{createUser},update_time=#{updateTime} where id=#{id}")
    void update(Article article);

    //删除
    @Delete("delete from article where id=#{id}")
    void deleteById(Integer id);
}
