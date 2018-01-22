package com.wisn.protocol.session;

import com.wisn.tools.LogUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {
    private static final ConcurrentHashMap<String, TokenEntity> onLineUsers = new ConcurrentHashMap<>();

    public static boolean putToken(String token, TokenEntity tokenEntity) {
        print();
        if (token == null || tokenEntity == null) {
            return false;
        }
        onLineUsers.put(token, tokenEntity);
        return true;
    }

    public static boolean removeToken(String token) {
        if (token == null) {
            return false;
        }
        onLineUsers.remove(token);
        return true;
    }

    public static TokenEntity getToken(String token) {
        return onLineUsers.get(token);
    }

//    public static boolean isOnlineById(String token) {
//        TokenEntity tokenEntity = onLineUsers.get(token);
//        if (tokenEntity == null) return false;
//        return tokenEntity.isExpired();
//    }

    public static boolean isOnline(String tokenStr) {
        print();
        if (tokenStr == null) return false;
        TokenEntity token = onLineUsers.get(tokenStr);
        if (token == null || token.getUserid() == 0) return false;
        return !token.isExpired();
    }

    public static void print() {
        Iterator<Map.Entry<String, TokenEntity>> iterator = onLineUsers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, TokenEntity> next = iterator.next();
            System.out.println("token:" + next.getKey() + " toknenty:" + next.getValue().toString());
        }
    }


}
