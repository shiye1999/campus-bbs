package com.csp.back.config;

import com.csp.back.config.interception.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns( "/*/*.html", "/*/*.js", "/*/*.css", "/*/*.woff", "/*/*.ttf")  // 放行静态文件
                .excludePathPatterns("/user/login", "/user/register"
//                        "/**/export", "/**/import", "/file/**",
//                        "/swagger-resources/**", "/webjars/**",
//                        "/v2/**", "/swagger-ui.html/**", "/api",
//                        "/api-docs", "/api-docs/**"
                );

    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
