package com.zhljava.qqclient.service;

import com.zhljava.qqcommon.Message;
import com.zhljava.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 提供和消息相关的服务方法
 */
public class MessageClientService {

    public void sendMessageToOne(String content, String senderId, String getterId) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通聊天消息
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对 " + getterId + " 说: " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.
                            getClientConnectServerThread(senderId).getSocket().
                            getOutputStream());

            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessageToAll(String content, String senderId) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发聊天消息
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对所有人说: " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.
                            getClientConnectServerThread(senderId).getSocket().
                            getOutputStream());

            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
