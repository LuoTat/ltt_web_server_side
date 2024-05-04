package com.luotat.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotat.POJO.PageBean;
import com.luotat.POJO.Sch;
import com.luotat.mapper.SchMapper;
import com.luotat.service.impl.SchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchService implements SchServiceImpl
{
    @Autowired
    private SchMapper schMapper;

    @Override
    public void insert(Sch sch)
    {
        schMapper.insert(sch);
    }

    @Override
    public void delete(Integer id)
    {
        schMapper.delete(id);
    }

    @Override
    public void update(Sch sch)
    {
        schMapper.update(sch);
    }

    @Override
    public Sch getById(Integer id)
    {
        return schMapper.getById(id);
    }

    @Override
    public PageBean page(Integer courseId, Integer empId, Integer currentPage, Integer pageSize)
    {
        // 设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        // 执行条件分页查询
        List<Sch> schList = schMapper.list(courseId, empId);
        // 获取查询结果
        PageInfo<Sch> pageInfo = new PageInfo<>(schList);
        // 封装PageBean
        return new PageBean(pageInfo.getTotal(), schList);
    }
}
