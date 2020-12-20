package com.soa.framework.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public TokenIntercetor tokenIntercetor(){
        return new TokenIntercetor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器拦截所有路径，除了login
        registry.addInterceptor(tokenIntercetor()).addPathPatterns("/**")
                .excludePathPatterns("/user/create")
                .excludePathPatterns("/hello")
                .excludePathPatterns("/login")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //解决跨域请求
    @Bean
    public CorsFilter corsFilter(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域请求（所有）
        corsConfiguration.addAllowedOrigin("*");
        //设置允许的方法(所有）get，put...
        corsConfiguration.addAllowedMethod("*");
        //允许任何头部
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader("token");

        //CorsFilter依赖于
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);


        return new CorsFilter(urlBasedCorsConfigurationSource);

    }

}
