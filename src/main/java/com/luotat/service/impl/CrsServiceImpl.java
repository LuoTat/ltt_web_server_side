package com.luotat.service.impl;

import com.luotat.POJO.Crs;
import com.luotat.POJO.PageBean;

import java.time.LocalDate;


public interface CrsServiceImpl
{
    void insert(Crs crs);

    void delete(Integer id);

    void update(Crs crs);

    Crs getById(Integer id);

    PageBean page(String name, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize);
}
