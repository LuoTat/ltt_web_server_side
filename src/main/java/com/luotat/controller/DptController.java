package com.luotat.controller;

import com.luotat.POJO.Dpt;
import com.luotat.Result.Result;
import com.luotat.service.DptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dpts")
public class DptController
{

    @Autowired
    private DptService dptService;

    //增加部门
    @PostMapping
    public Result insert(@RequestBody Dpt dpt)
    {
        try
        {
            dptService.insert(dpt);
            return Result.success("部门添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("部门名已存在");
        }
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id)
    {
        try
        {
            dptService.delete(id);
            return Result.success("部门删除成功");
        }
        catch (DataIntegrityViolationException e)
        {
            return Result.error("该部门有员工，无法删除");
        }
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dpt dpt)
    {
        try
        {
            dptService.update(dpt);
            return Result.success("部门修改成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("部门名已存在");
        }
    }

    //根据id查询部门
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Dpt dpt = dptService.getById(id);
        return Result.success(dpt, "查询成功");
    }

    //获得所有部门
    @GetMapping
    public Result list()
    {
        return Result.success(dptService.list(), "获取所有部门成功");
    }
}
