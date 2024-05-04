package com.luotat.controller;

import com.luotat.POJO.PageBean;
import com.luotat.POJO.Sch;
import com.luotat.Result.Result;
import com.luotat.service.SchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schs")
public class SchController
{
    @Autowired
    private SchService schService;

    // 增加课表
    @PostMapping
    public Result insert(@RequestBody Sch sch)
    {
        try
        {
            schService.insert(sch);
            return Result.success("课表添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("该课表已存在");
        }
    }

    // 删除课表
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id)
    {
        schService.delete(id);
        return Result.success("删除课表成功");
    }

    // 修改课表
    @PutMapping
    public Result update(@RequestBody Sch sch)
    {
        try
        {
            schService.update(sch);
            return Result.success("修改课表成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("课表名已存在");
        }
    }

    // 根据id查询课表
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Sch sch = schService.getById(id);
        return Result.success(sch, "查询课表成功");
    }

    // 分页条件查询课表
    @GetMapping
    public Result page(Integer courseId, Integer empId,
                       @RequestParam(defaultValue = "1") Integer currentPage,
                       @RequestParam(defaultValue = "10") Integer pageSize)
    {
        PageBean pageBean = schService.page(courseId, empId, currentPage, pageSize);
        return Result.success(pageBean, "分页查询课表成功");
    }
}