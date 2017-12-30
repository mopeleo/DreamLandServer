package com.dl.server.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.dl.server.service.impl.sys.SysCustServiceImpl;

public class BaseHandler implements WebSocketHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("====afterConnectionEstablished====");
    }

    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("====handleMessage====");
        System.out.println(message.getPayload());
        String sendData = "{\"service\":\"userservice\",\"success\":true,\"retmsg\":\"success\",\"results\":[{\"nickname\":\"leo\", \"age\":30}]}";
        session.sendMessage(new TextMessage(sendData));
    }

    @Override
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("====handleTransportError====");

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("====afterConnectionClosed====");

    }

    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        System.out.println("====supportsPartialMessages====");
        return false;
    }
}
