package com.dl.server.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.dl.server.websocket.handler.CustServiceHandler;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class DLWebSocketConfigurer extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //提供符合W3C标准的Websocket数据 
        registry.addHandler(getCustServiceHandler(), "/websocket/userservice").setAllowedOrigins("*");
        //提供符合SockJS的数据
        registry.addHandler(getCustServiceHandler(), "/websocket/sockjs/userservice").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public CustServiceHandler getCustServiceHandler() {
        return new CustServiceHandler();
    }
}
