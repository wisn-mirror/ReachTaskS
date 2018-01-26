package com.wisn.protocol.module;

import com.wisn.protocol.module.constant.CmdId;
import com.wisn.protocol.module.constant.ModuleId;
import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;
import com.wisn.protocol.protobuf.beans.EMessageMudule;

@SocketModule(module= ModuleId.chatMessage)
public interface ChartMessage {
    @SocketCmd(cmd = CmdId.ChartMessage.sendMessageToOne)
    short sengMessageToOne( EMessageMudule.EMessage message);
    @SocketCmd(cmd = CmdId.ChartMessage.sendMessageToAll)
    short sengMessageToAll( EMessageMudule.EMessage message);
}