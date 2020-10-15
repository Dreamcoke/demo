package com.qhw.demo.interceptor;

import com.qhw.demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        Claims claims;
        claims=JwtUtils.parseToken(token);
        if (claims!=null){
            return true;
        }
        return false;
    }
}
