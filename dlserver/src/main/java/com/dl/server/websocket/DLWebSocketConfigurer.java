package com.dl.server.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.dl.server.websocket.handler.ChatChannelHandler;
import com.dl.server.websocket.handler.CustServiceHandler;
import com.dl.server.websocket.interceptor.SessionCheckInterceptor;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class DLWebSocketConfigurer implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //提供符合W3C标准的Websocket数据 
        registry.addHandler(getCustServiceHandler(), "/websocket/userservice").setAllowedOrigins("*").addInterceptors(getSessionCheck());
        //提供符合SockJS的数据
        registry.addHandler(getCustServiceHandler(), "/websocket/sockjs/userservice").setAllowedOrigins("*").addInterceptors(getSessionCheck()).withSockJS();

        registry.addHandler(getChatHandler(), "/websocket/chat").setAllowedOrigins("*").addInterceptors(getSessionCheck());
        registry.addHandler(getChatHandler(), "/websocket/sockjs/chat").setAllowedOrigins("*").addInterceptors(getSessionCheck()).withSockJS();
}

    @Bean
    public SessionCheckInterceptor getSessionCheck(){
        return new SessionCheckInterceptor();
    }
    
    @Bean
    public ChatChannelHandler getChatHandler() {
        return new ChatChannelHandler();
    }
    
    @Bean
    public CustServiceHandler getCustServiceHandler() {
        return new CustServiceHandler();
    }
}
