package com.dl.server.listener;

import com.corundumstudio.socketio.SocketIOServer;
import com.dl.server.dto.system.SysUserDTO;
import com.dl.server.listener.system.UserServiceListener;

public class ListenerRegedit {
    
    public static void registerListener(SocketIOServer server){
        server.addConnectListener(new ServerConnectListener());
        server.addDisconnectListener(new ServerDisconnectListener());
        
        //业务监听器
        server.addEventListener("userservice", SysUserDTO.class, new UserServiceListener());
    }
}
