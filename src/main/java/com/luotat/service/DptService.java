package com.luotat.service;

import com.luotat.POJO.Dpt;
import com.luotat.mapper.DptMapper;
import com.luotat.service.impl.DptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DptService implements DptServiceImpl
{
    @Autowired
    private DptMapper dptMapper;

    @Override
    public void insert(Dpt dpt)
    {
        dptMapper.insert(dpt);
    }

    @Override
    public void delete(Integer id)
    {
        dptMapper.delete(id);
    }

    @Override
    public void update(Dpt dpt)
    {
        dptMapper.update(dpt);
    }

    @Override
    public Dpt getById(Integer id)
    {
        return dptMapper.getById(id);
    }

    @Override
    public List<Dpt> list()
    {
        return dptMapper.list();
    }
}
