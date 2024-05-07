package com.luotat.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.luotat.POJO.Emp;
import com.luotat.POJO.GenderBean;
import com.luotat.POJO.JobBean;
import com.luotat.POJO.PageBean;
import com.luotat.Result.Result;
import com.luotat.service.EmpService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.luotat.JWT.Utils.JWTUtils.parseJWT;

@Data
@RestController
@RequestMapping("/emps")
public class EmpController
{
    @Autowired
    private EmpService empService;

    //增加员工
    @PostMapping
    public Result insert(@RequestBody Emp emp)
    {
        try
        {
            empService.insert(emp);
            return Result.success("员工添加成功");
        }
        catch (DuplicateKeyException e)
        {
            return Result.error("员工用户名已存在");
        }
    }

    //删除员工
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids)
    {
        try
        {
            empService.delete(ids);
            return Result.success("删除员工成功");
        }
        catch (DataIntegrityViolationException e)
        {
            return Result.error("该员工有班级或课表，不能删除");
        }
    }

    //修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp)
    {
        try
        {
            empService.update(emp);
            return Result.success("修改员工成功");

        }
        catch (DuplicateKeyException e)
        {
            return Result.error("员工用户名已存在");
        }
    }

    // 修改密码
    @PutMapping("/changepwd")
    public Result changePassword(String jwt, String oldPasswd, String newPasswd)
    {
        DecodedJWT decodedJWT = parseJWT(jwt);
        if (decodedJWT == null)
        {
            return Result.error("token无效");
        }
        Integer id = (Integer) decodedJWT.getClaim("LogIn").asMap().get("id");
        if (!empService.checkPassword(id, oldPasswd))
        {
            return Result.error("原密码错误");
        }
        empService.changePassword(id, newPasswd);
        return Result.success("修改密码成功");
    }

    //查询男女员工数量
    @GetMapping("/getGenderCount")
    public Result getGenderCount()
    {
        List<GenderBean> genderCount = empService.getGenderCount();
        return Result.success(genderCount, "查询男女员工数量成功");
    }

    //查询不同Job人数
    @GetMapping("/getJobCount")
    public Result getJobCount()
    {
        List<JobBean> jobCount = empService.getJobCount();
        return Result.success(jobCount, "查询不同Job人数成功");
    }

    //根据id查询员工
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id)
    {
        Emp emp = empService.getById(id);
        return Result.success(emp, "查询员工成功");
    }

    //分页条件查询员工
    @GetMapping
    public Result page(String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer currentPage,
                       @RequestParam(defaultValue = "10") Integer pageSize)
    {
        PageBean pageBean = empService.page(name, gender, begin, end, currentPage, pageSize);
        return Result.success(pageBean, "分页查询员工成功");
    }
}