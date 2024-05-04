package com.luotat.controller;

import com.luotat.POJO.Crs;
import com.luotat.POJO.PageBean;
import com.luotat.Result.Result;
import com.luotat.service.CrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/crss")
public class CrsController
{
    @Autowired
    private CrsService crsService;

    // 增加课程
    @PostMapping
    public Result insert(@RequestBody Crs crs)
    {
        try
        {
            crsService.insert(crs);
            return Result.success("课程添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("课程名已存在");
        }
    }

    // 删除课程
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id)
    {
        crsService.delete(id);
        return Result.success("删除课程成功");
    }

    // 修改课程
    @PutMapping
    public Result update(@RequestBody Crs crs)
    {
        try
        {
            crsService.update(crs);
            return Result.success("修改课程成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("课程名已存在");
        }
    }

    // 根据id查询课程
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Crs crs = crsService.getById(id);
        return Result.success(crs, "查询课程成功");
    }

    // 分页条件查询课程
    @GetMapping
    public Result page(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer currentPage,
                       @RequestParam(defaultValue = "10") Integer pageSize)
    {
        PageBean pageBean = crsService.page(name, begin, end, currentPage, pageSize);
        return Result.success(pageBean, "分页查询课程成功");
    }
}