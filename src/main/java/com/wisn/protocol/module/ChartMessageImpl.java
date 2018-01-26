package com.wisn.protocol.module;

import com.wisn.protocol.module.constant.CmdId;
import com.wisn.protocol.module.constant.ModuleId;
import com.wisn.protocol.ResponseCode;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.session.SessionManager;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;
@Component
public class ChartMessageImpl implements ChartMessage {

    @Override
    public short sengMessageToOne(EMessageMudule.EMessage message) {
        boolean sendMessage = SessionManager.sendMessage(message.getTargetuserid()
                , ModuleId.chatMessage, CmdId.ChartMessage.sendMessageToOne, ResponseCode.newMessage, message);
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
            if(next==message.getFromuserid()){

                //continue;
            }
            SessionManager.sendMessage(next
                    , ModuleId.chatMessage, CmdId.ChartMessage.sendMessageToOne, ResponseCode.newMessage, message);
        }
        return ResponseCode.SUCCESS;
    }
}
