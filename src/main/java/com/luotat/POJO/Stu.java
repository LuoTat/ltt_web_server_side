package com.luotat.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu
{
    private Integer id; //学生id
    private String name;//学生姓名
    private String studentId;//学号
    private Short gender;//学生性别
    private String phoneNumber;//学生电话
    private Short educationLevel;//学生学历
    private Short infractionNum;//学生违纪次数
    private Short infractionPoint;//学生违纪分数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间
    private Integer classId;//学生班级id
}