package com.luotat.service.impl;

import com.luotat.POJO.Cls;
import com.luotat.POJO.PageBean;

import java.time.LocalDate;

public interface ClsServiceImpl
{
    void insert(Cls cls);

    void delete(Integer id);

    void update(Cls cls);

    Cls getById(Integer id);

    PageBean page(String name, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize);
}
