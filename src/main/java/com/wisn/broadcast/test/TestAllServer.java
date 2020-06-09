package com.wisn.broadcast.test;

import com.wisn.broadcast.BroadcastAll;
import com.wisn.broadcast.MessageCall;
import com.wisn.broadcast.UdpConfig;

public class TestAllServer {
    public static void main(String[] arg){
        BroadcastAll broadcastAll=new BroadcastAll();
        broadcastAll.listenerMessage(UdpConfig.All_ServerportRecevie, new MessageCall() {
            @Override
            public void callBackMessage(String message, String ip) {
                System.out.println(" server MESSAGE:"+message+" ip:"+ip);

                broadcastAll.sendBackMessage(UdpConfig.groupALL,UdpConfig.All_ServerportSend,"server:"+message);
            }
        });
    }
}
