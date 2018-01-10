package com.wisn.protocol.session;

import com.google.protobuf.GeneratedMessage;
import com.wisn.protocol.response.Response;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static final ConcurrentHashMap<Long, Session> onLineSessions = new ConcurrentHashMap<>();

    public static boolean putSession(Long id, Session session) {
        if (!onLineSessions.containsKey(id)) {
            return onLineSessions.putIfAbsent(id, session) != null;
        }
        return false;
    }

    public static <T extends GeneratedMessage> boolean sendMessage(long id, short module, short cmd, short statusCode, T message) {
        Session session = onLineSessions.get(id);
        if (session != null && session.isConnected()) {
            Response response = Response.valueOf(module, cmd, statusCode, message.toByteArray());
            session.write(response);
            return true;
        }
        return false;
    }

    public static Session removeSession(long id) {
        return onLineSessions.remove(id);
    }

    public static boolean isOnline(long id) {
        return onLineSessions.containsKey(id);
    }

    public static Set<Long> getOnlines() {
        return Collections.unmodifiableSet(onLineSessions.keySet());
    }
}
