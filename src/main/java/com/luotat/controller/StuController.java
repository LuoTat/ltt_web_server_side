package com.luotat.controller;

import com.luotat.POJO.*;
import com.luotat.Result.Result;
import com.luotat.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stus")
public class StuController
{
    @Autowired
    private StuService stuService;

    //增加学生
    @PostMapping
    public Result insert(@RequestBody Stu stu)
    {
        try
        {
            stuService.insert(stu);
            return Result.success("学生添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("学生学号或电话号码已存在");
        }
    }

    //删除学生
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids)
    {
        stuService.delete(ids);
        return Result.success("删除学生成功");
    }

    //修改学生
    @PutMapping
    public Result update(@RequestBody Stu stu)
    {
        try
        {
            stuService.update(stu);
            return Result.success("修改学生成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("学生学号或电话号码已存在");
        }
    }

    //查询男女学员数量
    @GetMapping("/getGenderCount")
    public Result getGenderCount()
    {
        List<GenderBean> genderCount = stuService.getGenderCount();
        return Result.success(genderCount, "查询男女学员数量成功");
    }

    //查询不同EducationLevel人数
    @GetMapping("/getEducationLevelCount")
    public Result getEducationLevelCount()
    {
        List<educationLevelBean> educationLevelCount = stuService.getEducationLevelCount();
        return Result.success(educationLevelCount, "查询不同EducationLevel人数成功");
    }

    //根据id查询学生
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Stu stu = stuService.getById(id);
        return Result.success(stu, "查询学生成功");
    }

    //分页条件查询学生
    @GetMapping
    public Result page(String name, String studentId, Short educationLevel, Short classId, @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize)
    {
        PageBean pageBean = stuService.page(name, studentId, educationLevel, classId, currentPage, pageSize);
        return Result.success(pageBean, "分页查询学生成功");
    }
}