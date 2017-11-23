package com.dl.server.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class ServerDisconnectListener implements DisconnectListener{

    @Override
    public void onDisconnect(SocketIOClient client) {
        System.out.println(client.getRemoteAddress() + " web客户端断开");        
    }
}
