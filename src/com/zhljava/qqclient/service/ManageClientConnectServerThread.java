package com.zhljava.qqclient.service;

import java.util.HashMap;

/**
 * 管理客户端链接到服务器端的线程
 */
public class ManageClientConnectServerThread {
    //key 是用户id
    private static HashMap<String, ClientConnectServerThread> map = new HashMap<>();

    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        map.put(userId, clientConnectServerThread);
    }

    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return map.get(userId);
    }

}
