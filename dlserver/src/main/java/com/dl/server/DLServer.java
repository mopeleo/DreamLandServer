package com.dl.server;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.dl.server.common.SpringContext;
import com.dl.server.listener.ListenerRegistry;

public class DLServer {
    private static final ResourceBundle rb = ResourceBundle.getBundle("dlserver");
    
    public static String getConfig(String key, String defaultValue) {
        String value = null;
        try{
            value = rb.getString(key);
            if(value == null || value.equals("")){
                value = defaultValue;
            }
        }catch(MissingResourceException e){
            value = defaultValue;
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        //启动spring
        SpringContext.getApplicationContext();
        
        //启动socketio服务端
        Configuration config = new Configuration();
        config.setHostname(rb.getString("host"));
        config.setPort(Integer.parseInt(getConfig("port", "3000")));
        SocketIOServer server = new SocketIOServer(config);
        //添加事件监听器
        ListenerRegistry.registerListener(server);
        server.start();
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }
}
