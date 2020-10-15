package com.qhw.demo.config;

import com.qhw.demo.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/user/**") //其他接口拦截
                .addPathPatterns("/login/**")
                .addPathPatterns("/role/**")
                .addPathPatterns("/dept/**")
                .addPathPatterns("/menu/**")
                .excludePathPatterns("/login/test");//放行认证接口
    }
}
