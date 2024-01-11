package com.research.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.research.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
@Data
public class Article {
    private Integer id;//主键ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,50}$")
    private String title;//算法名称
    @NotEmpty
    private String fromWhere;//出处
    @NotEmpty
    private String keyWords;//关键字
    @NotNull
    private Integer categoryId;//所属科研方向
    @NotEmpty
    private String content;//附件代码
    @NotEmpty
    private String instruction;//使用说明

    @NotEmpty
    @URL
    private String exampleDataSet;//样例数据集

    @NotEmpty
    @URL
    private String exampleQuery;//样例查询

    @State
    private String state;//发布状态 已发布|草稿

    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间
}
