package com.wisn.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class BroadcastGroup {



    public  void listenerMessage(String IP,int listenerPort,MessageCall messageCall) {
        try {
            byte[] data = new byte[256];
            MulticastSocket ms = new MulticastSocket(listenerPort);
            ms.joinGroup(InetAddress.getByName(IP));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            //receive()是阻塞方法，会等待客户端发送过来的信息
                            DatagramPacket packet = new DatagramPacket(data, data.length);
                            ms.receive(packet);
                            String message = new String(packet.getData(), 0, packet.getLength());
                            System.out.println(message);
                            if(messageCall!=null){
                                messageCall.callBackMessage(message,packet.getAddress().getHostAddress());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        ms.close();
                    }
                }
            }).start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public   void sendBackMessage(String IP,int sendPort,String message){
        try {
            MulticastSocket ms = new MulticastSocket();
            ms.setTimeToLive(32);
            //将本机的IP（这里可以写动态获取的IP）地址放到数据包里，其实server端接收到数据包后也能获取到发包方的IP的
            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName(IP);
            DatagramPacket dataPacket = new DatagramPacket(data, data.length, address,sendPort);
            ms.send(dataPacket);
            ms.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
