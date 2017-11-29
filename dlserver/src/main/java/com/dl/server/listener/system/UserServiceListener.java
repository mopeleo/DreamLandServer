package com.dl.server.listener.system;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.dl.base.exception.DLServiceException;
import com.dl.server.common.SpringContext;
import com.dl.server.dto.ResultDTO;
import com.dl.server.dto.system.SysUserDTO;
import com.dl.server.service.system.SysUserService;

public class UserServiceListener implements DataListener<SysUserDTO>{

    @Override
    public void onData(SocketIOClient client, SysUserDTO user, AckRequest ackSender) throws Exception {
        String action = user.getAction();
        if(action.equalsIgnoreCase("login")){
            SysUserService userService = SpringContext.getBean("sysUserServiceImpl");
            ResultDTO<SysUserDTO> result = userService.getById(user.getUserid());
            client.sendEvent("userservice", result);
        }else if(action.equalsIgnoreCase("query")){

        }else{
            throw new DLServiceException("暂未实现action[" + action + "]");
        }
    }
}
