package com.board.shopingboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // 개발 시점에 사용 가능한 코드.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String filepath = "file:///" + System.getProperty("user.dir") + "/src/main/resources/static/image/";
        registry.addResourceHandler("/**","/item/**").addResourceLocations(filepath);
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(60 * 60 * 24 * 365);
        /* '/css/**'로 호출하는 자원은 '/static/css/' 폴더 아래에서 찾는다. */
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60 * 60 * 24 * 365);
    }

}
