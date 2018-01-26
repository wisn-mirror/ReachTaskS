package com.wisn.protocol.module;

import com.wisn.protocol.module.constant.CmdId;
import com.wisn.protocol.module.constant.ModuleId;
import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.session.Session;

@SocketModule(module = ModuleId.AuthMessage)
public interface AuthMessage {
    @SocketCmd(cmd = CmdId.AuthMessage.register)
    short register(Session session,EMessageMudule.EMessage message);

}