package com.dl.server.listener;

import com.corundumstudio.socketio.SocketIOServer;
import com.dl.server.dto.sys.SysCustDTO;
import com.dl.server.listener.system.CustServiceListener;

public class ListenerRegistry {
    
    public static void registerListener(SocketIOServer server){
        server.addConnectListener(new ServerConnectListener());
        server.addDisconnectListener(new ServerDisconnectListener());
        
        //业务监听器
        server.addEventListener("userservice", SysCustDTO.class, new CustServiceListener());

    }
}
