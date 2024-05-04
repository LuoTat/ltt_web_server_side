package com.luotat.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotat.POJO.Crs;
import com.luotat.POJO.PageBean;
import com.luotat.mapper.CrsMapper;
import com.luotat.service.impl.CrsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CrsService implements CrsServiceImpl
{
    @Autowired
    private CrsMapper crsMapper;

    @Override
    public void insert(Crs crs)
    {
        crsMapper.insert(crs);
    }

    @Override
    public void delete(Integer id)
    {
        crsMapper.delete(id);
    }

    @Override
    public void update(Crs crs)
    {
        crsMapper.update(crs);
    }

    @Override
    public Crs getById(Integer id)
    {
        return crsMapper.getById(id);
    }

    @Override
    public PageBean page(String name, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize)
    {
        // 设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        // 执行条件分页查询
        List<Crs> crsList = crsMapper.list(name, begin, end);
        // 获取查询结果
        PageInfo<Crs> pageInfo = new PageInfo<>(crsList);
        // 封装PageBean
        return new PageBean(pageInfo.getTotal(), crsList);
    }
}
