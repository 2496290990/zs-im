package com.im.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.common.Result;
import com.im.common.ResultFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaojinhui
 * @date 2021/2/28 17:31
 * @apiNote 认证失败的处理器
 */
public class UnauthHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result = ResultFactory.buildResult(401, "fail", "用户认证失败");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(result));

    }
}
