package com.chryl.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created By Chr on 2019/6/17.
 */
@EnableWebSocket
public class WebCallConfigurer implements WebSocketConfigurer {

    @Value("${web.url}")
    private String webUrl;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.setProperty("kms.url", webUrl);
        registry.addHandler(new WebCallHandler(), "/webcall").setAllowedOrigins("*");
    }

}
