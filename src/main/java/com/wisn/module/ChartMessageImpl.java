package com.wisn.module;

import com.wisn.module.constant.CmdId;
import com.wisn.module.constant.ModuleId;
import com.wisn.protocol.ResponseCode;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.session.SessionManager;

import java.util.Iterator;
import java.util.Set;

public class ChartMessageImpl implements ChartMessage {

    @Override
    public short sengMessageToOne(EMessageMudule.EMessage message) {
        boolean sendMessage = SessionManager.sendMessage(message.getTargetuserid()
                , ModuleId.chatMessage, CmdId.ChartMessage.sendMessageToOne, ResponseCode.SUCCESS, message);
        if (sendMessage)
            return ResponseCode.SUCCESS;
        return ResponseCode.SERVER_EXCEPTION;
    }

    @Override
    public short sengMessageToAll(EMessageMudule.EMessage message) {
        Set<Long> onlines = SessionManager.getOnlines();
        Iterator<Long> iterator = onlines.iterator();
        while (iterator.hasNext()) {
            Long next = iterator.next();
            SessionManager.sendMessage(next
                    , ModuleId.chatMessage, CmdId.ChartMessage.sendMessageToOne, ResponseCode.SUCCESS, message);
        }
        return ResponseCode.SUCCESS;
    }
}
