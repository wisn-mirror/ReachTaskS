package com.wisn.protocol.session;

import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {
    private static final ConcurrentHashMap<String, TokenEntity> onLineUsers = new ConcurrentHashMap<>();

    public static void putToken(String token, TokenEntity tokenEntity) {
        onLineUsers.put(token, tokenEntity);
    }

    public static void removeToken(String token, TokenEntity tokenEntity) {
        onLineUsers.remove(token);
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

        if(tokenStr==null)return false;
        TokenEntity token = onLineUsers.get(tokenStr);
        if (token == null || token.getUserid() == 0) return false;
        return token.isExpired();
    }


}
