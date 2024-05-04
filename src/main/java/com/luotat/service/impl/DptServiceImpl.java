package com.luotat.service.impl;

import com.luotat.POJO.Dpt;

import java.util.List;

public interface DptServiceImpl
{
    void insert(Dpt dpt);

    void delete(Integer id);

    void update(Dpt dpt);

    Dpt getById(Integer id);

    List<Dpt> list();
}
