package com.dl.server.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;

public class ServerConnectListener implements ConnectListener{

    @Override
    public void onConnect(SocketIOClient client) {
        System.out.println(client.getRemoteAddress() + " web客户端接入");
        client.sendEvent("connected", "hello, connected");        
    }
}
