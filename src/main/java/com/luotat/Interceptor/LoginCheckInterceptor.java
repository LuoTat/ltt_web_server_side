package com.luotat.Interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luotat.JWT.Utils.JWTUtils;
import com.luotat.Result.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

// 自定义登录拦截器
@Component
public class LoginCheckInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws IOException
    {
        // 目标资源方法执行前执行
        System.out.println("开始验证身份");
        //获取请求头中的token
        String token = request.getHeader("Authorization");
        try
        {
            JWTUtils.parseJWT(token);
            System.out.println("解析token成功");
        }
        catch (JWTVerificationException e)
        {
            //创建响应结果对象
            Result responseResult = Result.error("NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);
            return false;//不放行
        }
        return true; //true表示放行
    }

    // 目标资源方法执行后执行
    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView)
    {
        System.out.println("结束验证身份");
    }

    // 视图渲染完毕后执行，最后执行
    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex)
    {
        System.out.println("拦截器执行完毕");
    }
}