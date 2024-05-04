package com.luotat.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cls
{
    private Integer id; //班级id
    private String name;//班级名称
    private String room;//班级教室
    private Integer teacher;//班主任
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate openTime;//开课时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate closeTime;//结课时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
}