package com.luotat.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luotat.POJO.GenderBean;
import com.luotat.POJO.PageBean;
import com.luotat.POJO.Stu;
import com.luotat.POJO.educationLevelBean;
import com.luotat.mapper.StuMapper;
import com.luotat.service.impl.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService implements StuServiceImpl
{
    @Autowired
    private StuMapper StuMapper;

    @Override
    public void insert(Stu stu)
    {
        StuMapper.insert(stu);
    }

    @Override
    public void delete(List<Integer> ids)
    {
        StuMapper.delete(ids);
    }

    @Override
    public void update(Stu stu)
    {
        StuMapper.update(stu);
    }

    @Override
    public List<GenderBean> getGenderCount()
    {
        return StuMapper.getGenderCount();
    }

    @Override
    public List<educationLevelBean> getEducationLevelCount()
    {
        return StuMapper.getEducationLevelCount();
    }

    @Override
    public Stu getById(Integer id)
    {
        return StuMapper.getById(id);
    }

    @Override
    public PageBean page(String name, String studentId, Short educationLevel, Short classId, Integer currentPage, Integer pageSize)
    {
        //设置分页参数
        PageHelper.startPage(currentPage, pageSize);
        //执行条件分页查询
        List<Stu> stuList = StuMapper.list(name, studentId, educationLevel, classId);
        //获取查询结果
        PageInfo<Stu> pageInfo = new PageInfo<>(stuList);
        //封装PageBean
        return new PageBean(pageInfo.getTotal(), stuList);
    }
}
