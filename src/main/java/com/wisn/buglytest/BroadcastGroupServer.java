package com.wisn.buglytest;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class BroadcastGroupServer {

    private static final int ServerportRecevie=8998;
    private static final int ServerportSend=8999;
    public static void main(String[] arg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] data = new byte[256];

                    MulticastSocket ms = new MulticastSocket(ServerportRecevie);
//                    ms.joinGroup(InetAddress.getByName("224.224.224.224"));
                    ms.joinGroup(InetAddress.getByName("225.0.0.1"));
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    //receive()是阻塞方法，会等待客户端发送过来的信息
                    ms.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println(message);
                    ms.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
