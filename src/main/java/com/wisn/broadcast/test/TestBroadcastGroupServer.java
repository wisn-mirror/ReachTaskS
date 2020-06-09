package com.wisn.broadcast.test;


import com.wisn.broadcast.BroadcastGroup;
import com.wisn.broadcast.MessageCall;
import com.wisn.broadcast.UdpConfig;

public class TestBroadcastGroupServer {

    public static void main(String[] arg) {
        BroadcastGroup Server=new BroadcastGroup();
        Server.listenerMessage(UdpConfig.groupIp, UdpConfig.Group_ServerportRecevie, new MessageCall() {
            @Override
            public void callBackMessage(String message, String ip) {
                System.out.println(" MESSAGE:"+message+" ip:"+ip);
                Server.sendBackMessage(UdpConfig.groupIp,UdpConfig.Group_ServerportSend,"CALL BACK:"+ message);
            }
        });
    }
}
