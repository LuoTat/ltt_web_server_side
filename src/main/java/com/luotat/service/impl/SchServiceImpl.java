package com.luotat.service.impl;

import com.luotat.POJO.PageBean;
import com.luotat.POJO.Sch;


public interface SchServiceImpl
{
    void insert(Sch sch);

    void delete(Integer id);

    void update(Sch sch);

    Sch getById(Integer id);

    PageBean page(Integer courseId, Integer empId, Integer currentPage, Integer pageSize);
}
