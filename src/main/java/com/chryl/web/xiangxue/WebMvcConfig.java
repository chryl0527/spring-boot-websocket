package com.chryl.web.xiangxue;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * xiangxue
 * <p>
 * Created By Chr on 2019/6/17.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws")
                .setViewName("/ws_chat");
    }
}
