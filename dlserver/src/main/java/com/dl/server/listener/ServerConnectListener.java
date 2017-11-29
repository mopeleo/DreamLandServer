package com.dl.server.listener;

import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;

public class ServerConnectListener implements ConnectListener{

    @Override
    public void onConnect(SocketIOClient client) {
        System.out.println(client.getRemoteAddress() + " web客户端接入");
        System.out.println("sessionid : " + client.getSessionId());
        HandshakeData hd = client.getHandshakeData();
        System.out.println("getUrl():" + hd.getUrl());
        System.out.println(hd.getHeaders());
        System.out.println(hd.getUrlParams());
        client.sendEvent("connected", "hello, connected");        
    }
}
