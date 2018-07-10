package com.dl.server.websocket.handler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.dl.base.exception.DLServiceException;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.sys.SysCustDTO;
import com.dl.server.service.impl.sys.SysCustServiceImpl;
import com.dl.server.service.sys.SysCustService;
import com.google.gson.Gson;

public class CustServiceHandler extends BaseHandler {
    private static Logger log = LoggerFactory.getLogger(CustServiceHandler.class);
    @Autowired
    private SysCustService userService;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        Gson gson = new Gson();
        SysCustDTO user = gson.fromJson((String)message.getPayload(), SysCustDTO.class);
        String action = user.getAction();
        if(action.equalsIgnoreCase("login")){
            ResultDTO<SysCustDTO> result = userService.login(user);
            log.info(gson.toJson(result));
            session.sendMessage(new TextMessage(gson.toJson(result)));
        }else if(action.equalsIgnoreCase("query")){

        }else{
            throw new DLServiceException("暂未实现action[" + action + "]");
        }
    }
}
