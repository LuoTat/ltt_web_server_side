package com.luotat.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sch
{
    private Integer id; // 课表id
    private Integer courseId; // 课程id
    private Integer empId; // 教师id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime; //创建时间

}
