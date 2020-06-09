package com.wisn.buglytest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BroadcastServer {
    private static final int ServerportRecevie=8998;
    private static final int ServerportSend=8999;
    public static void main(String[] arg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buffer = new byte[65507];
                    DatagramSocket ds = new DatagramSocket(ServerportRecevie);
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    while (true) {
                        try {
                            ds.receive(packet);
                            String s = new String(packet.getData(), 0, packet.getLength());
                            System.out.println(packet.getAddress() + ":" + packet.getPort() + "    →    " + s);
                             s= s+"from server";
                            DatagramPacket dp = new DatagramPacket(s.getBytes(), s.getBytes().length,
                                    InetAddress.getByName("255.255.255.255"), ServerportSend);
                            ds.send(dp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
