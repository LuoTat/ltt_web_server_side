package com.luotat.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotat.POJO.Emp;
import com.luotat.POJO.GenderBean;
import com.luotat.POJO.JobBean;
import com.luotat.POJO.PageBean;
import com.luotat.mapper.EmpMapper;
import com.luotat.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpService implements EmpServiceImpl
{
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp login(Emp emp)
    {
        return empMapper.login(emp);
    }

    @Override
    public void insert(Emp emp)
    {
        empMapper.insert(emp);
    }

    @Override
    public void delete(List<Integer> ids)
    {
        empMapper.delete(ids);
    }

    @Override
    public void update(Emp emp)
    {
        empMapper.update(emp);
    }

    @Override

    public boolean checkPassword(Integer id, String password)
    {
        return empMapper.checkPassword(id, password);
    }

    @Override
    public void changePassword(Integer id, String password)
    {
        empMapper.changePassword(id, password);
    }

    @Override
    public List<GenderBean> getGenderCount()
    {
        return empMapper.getGenderCount();
    }

    @Override
    public List<JobBean> getJobCount()
    {
        return empMapper.getJobCount();
    }

    @Override
    public Emp getById(Integer id)
    {
        return empMapper.getById(id);
    }

    @Override
    public PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer currentPage, Integer pageSize)
    {
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        //执行条件分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        //获取查询结果
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);
        //封装PageBean
        return new PageBean(pageInfo.getTotal(), empList);
    }
}
