package com.luotat.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crs
{
    private Integer id; //课程id
    private String name; //课程名
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate openTime;     //开课时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate closeTime;     //结课时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime; //创建时间
    private Integer classId; //班级id
}
