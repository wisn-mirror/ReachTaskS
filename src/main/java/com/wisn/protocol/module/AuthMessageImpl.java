package com.wisn.protocol.module;

import com.wisn.protocol.ResponseCode;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.session.Session;
import com.wisn.protocol.session.SessionManager;
import org.springframework.stereotype.Component;

@Component
public class AuthMessageImpl implements AuthMessage {
    @Override
    public short register(Session session, EMessageMudule.EMessage message) {
        if (!SessionManager.putSession(message.getFromuserid(), session)) {
           return ResponseCode.NO_AUTH;
        }
        return ResponseCode.SUCCESS;
    }
}
