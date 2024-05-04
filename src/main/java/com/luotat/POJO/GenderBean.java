package com.luotat.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenderBean
{
    // 性别
    private Short gender;
    // 性别人数
    private Integer count;
}
