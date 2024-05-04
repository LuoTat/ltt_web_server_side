package com.luotat.service.impl;

import com.luotat.POJO.Emp;
import com.luotat.POJO.GenderBean;
import com.luotat.POJO.JobBean;
import com.luotat.POJO.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface EmpServiceImpl
{
    Emp login(Emp emp);

    void insert(Emp emp);

    void delete(List<Integer> id);

    void update(Emp emp);

    boolean checkPassword(Integer id, String password);

    void changePassword(Integer id, String password);

    List<GenderBean>  getGenderCount();

    List<JobBean>  getJobCount();

    Emp getById(Integer id);

    PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize);
}
