package com.dl.server.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class BaseHandler implements WebSocketHandler {

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
