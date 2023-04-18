package com.siafweb.common.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginCheckInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/login") // 인터셉터 추가
                .excludePathPatterns(
                        "/test/**" ,
                        "/js/**",
                        "/css/**",
                        "/fonts/**"
                ); // 인터셉터에서 제외
    }
}