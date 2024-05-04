package com.luotat.service.impl;

import com.luotat.POJO.*;

import java.util.List;


public interface StuServiceImpl
{
    void insert(Stu stu);

    void delete(List<Integer> id);

    void update(Stu stu);

    List<GenderBean>  getGenderCount();

    List<educationLevelBean>  getEducationLevelCount();

    Stu getById(Integer id);

    PageBean page(String name, String studentId, Short educationLevel, Short classId, Integer currentPage, Integer pageSize);
}
