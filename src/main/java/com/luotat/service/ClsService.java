package com.luotat.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotat.POJO.Cls;
import com.luotat.POJO.Emp;
import com.luotat.POJO.PageBean;
import com.luotat.mapper.ClsMapper;
import com.luotat.service.impl.ClsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClsService implements ClsServiceImpl
{
    @Autowired
    private ClsMapper clsMapper;

    @Override
    public void insert(Cls cls)
    {
        clsMapper.insert(cls);
    }

    @Override
    public void delete(Integer id)
    {
        clsMapper.delete(id);
    }

    @Override
    public void update(Cls cls)
    {
        clsMapper.update(cls);
    }

    @Override
    public Cls getById(Integer id)
    {
        return clsMapper.getById(id);
    }

    @Override
    public PageBean page(String name, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize)
    {
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        //执行条件分页查询
        List<Emp> empList = clsMapper.list(name, begin, end);
        //获取查询结果
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);
        //封装PageBean
        return new PageBean(pageInfo.getTotal(), empList);
    }
}
