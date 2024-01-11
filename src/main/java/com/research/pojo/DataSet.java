package com.research.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
@Data
public class DataSet {
    private Integer id;//主键ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,50}$")
    private String title;//数据集名称
    @NotEmpty
    private String content;//数据集描述
    @NotEmpty
    private String keyWords;//关键字
    @NotEmpty
    private String fromWhere;//出处
    @NotNull
    private Integer categoryId;//所属科研方向

    @NotEmpty
    @URL
    private String attachment;//数据集附件

    @NotEmpty
    private String instruction;//使用说明

    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间
}
