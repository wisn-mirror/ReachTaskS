package com.wisn.broadcast.test;


import com.wisn.broadcast.BroadcastGroup;
import com.wisn.broadcast.MessageCall;
import com.wisn.broadcast.UdpConfig;

public class TestBroadcastGroupClient2 {

    public static void main(String[] arg) {
        BroadcastGroup Client=new BroadcastGroup();
        Client.listenerMessage(UdpConfig.groupIp, UdpConfig.Group_ServerportSend, new MessageCall() {
            @Override
            public void callBackMessage(String message, String ip) {
                System.out.println(" MESSAGE:"+message+" ip:"+ip);
            }
        });
        Client.sendBackMessage(UdpConfig.groupIp,UdpConfig.Group_ServerportRecevie,"AABBC");
    }
}
