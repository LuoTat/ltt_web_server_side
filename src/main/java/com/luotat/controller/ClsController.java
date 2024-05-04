package com.luotat.controller;

import com.luotat.POJO.Cls;
import com.luotat.POJO.PageBean;
import com.luotat.Result.Result;
import com.luotat.service.ClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/clss")
public class ClsController
{
    @Autowired
    private ClsService clsService;

    //增加班级
    @PostMapping
    public Result insert(@RequestBody Cls cls)
    {
        try
        {
            clsService.insert(cls);
            return Result.success("班级添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("班级名已存在");
        }
    }

    //删除班级
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id)
    {
        clsService.delete(id);
        return Result.success("删除班级成功");
    }

    //修改班级
    @PutMapping
    public Result update(@RequestBody Cls cls)
    {
        try
        {
            clsService.update(cls);
            return Result.success("修改班级成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("班级名已存在");
        }
    }

    //根据id查询班级
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Cls cls = clsService.getById(id);
        return Result.success(cls, "查询班级成功");
    }

    //分页条件查询班级
    @GetMapping
    public Result page(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer currentPage,
                       @RequestParam(defaultValue = "10") Integer pageSize)
    {
        PageBean pageBean = clsService.page(name, begin, end, currentPage, pageSize);
        return Result.success(pageBean, "分页查询班级成功");
    }
}