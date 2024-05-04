package com.luotat.controller;

import com.luotat.JWT.Utils.JWTUtils;
import com.luotat.POJO.Emp;
import com.luotat.Result.Result;
import com.luotat.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController
{

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp)
    {
        Emp loginEmp = empService.login(emp);
        if (loginEmp != null)
        {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("username", loginEmp.getUsername());
            claims.put("name", loginEmp.getName());
            String token = JWTUtils.generateJWT(claims);
            return Result.success(token, "登录成功");
        }
        else
        {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/verifyToken")
    public Result verifyToken()
    {
        return Result.success("jwtToken验证成功");
    }
}