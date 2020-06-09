package com.wisn.buglytest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BroadcastClient {
    //发送端的端口和接收端的端口一致
    private static final int portRecevie=8999;
    private static final int portSend=8998;
    public static void main(String[] arg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buffer = new byte[65507];
                    DatagramSocket ds = new DatagramSocket(portRecevie);
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    while (true) {
                        try {
                            ds.receive(packet);
                            String s = new String(packet.getData(), 0, packet.getLength());
                            System.out.println(packet.getAddress() + " hostname" +packet.getAddress().getHostName()+ ":" + packet.getPort() + "    →    " + s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            String msg="333";
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
                    InetAddress.getByName("255.255.255.255"), portSend);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
