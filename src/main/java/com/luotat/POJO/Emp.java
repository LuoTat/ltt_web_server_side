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
public class Emp
{
    private Integer id; //员工id
    private String username; //员工用户名
    private String name;//员工姓名
    private String password;//员工密码
    private Short gender;//员工性别
    private String image;//员工头像
    private Short job;//员工职位
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;     //入职日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间
    private Short deptId;
}