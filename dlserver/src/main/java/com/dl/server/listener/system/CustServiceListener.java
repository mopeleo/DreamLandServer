package com.dl.server.listener.system;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.dl.base.exception.DLServiceException;
import com.dl.server.common.SpringContext;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.sys.SysCustDTO;
import com.dl.server.service.sys.SysCustService;

public class CustServiceListener implements DataListener<SysCustDTO>{

    @Override
    public void onData(SocketIOClient client, SysCustDTO user, AckRequest ackSender) throws Exception {
        String action = user.getAction();
        if(action.equalsIgnoreCase("login")){
            SysCustService userService = SpringContext.getBean("sysCustServiceImpl");
            ResultDTO<SysCustDTO> result = userService.login(user);
            client.sendEvent("userservice", result);
        }else if(action.equalsIgnoreCase("query")){

        }else{
            throw new DLServiceException("暂未实现action[" + action + "]");
        }
    }
}
