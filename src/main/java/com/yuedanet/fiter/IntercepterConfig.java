package com.yuedanet.fiter;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class IntercepterConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /***
         * 拦截器按顺序执行
         */
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*/**");

    }
}

