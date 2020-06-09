package com.wisn.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastAll {

    public void listenerMessage(int listenerPort, MessageCall messageCall) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DatagramSocket ds=null;
                try {
                    byte[] buffer = new byte[65507];
                    ds = new DatagramSocket(listenerPort);
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    while (true) {
                        ds.receive(packet);
                        String message = new String(packet.getData(), 0, packet.getLength());
                        System.out.println(packet.getAddress() + " hostname" + packet.getAddress().getHostName() + ":" + packet.getPort() + "    →    ");
                        if (messageCall != null) {
                            messageCall.callBackMessage(message, packet.getAddress().getHostAddress());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(ds!=null){
                        ds.close();
                    }
                }
            }
        }).start();

    }

    public void sendBackMessage(String IP, int sendPort, String message) {
        try {
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length,
                    InetAddress.getByName(IP), sendPort);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
