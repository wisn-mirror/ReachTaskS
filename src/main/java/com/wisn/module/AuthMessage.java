package com.wisn.module;

import com.wisn.entity.Message;
import com.wisn.module.constant.CmdId;
import com.wisn.module.constant.ModuleId;
import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.session.Session;

@SocketModule(module = ModuleId.AuthMessage)
public interface AuthMessage {
    @SocketCmd(cmd = CmdId.AuthMessage.register)
    short register(Session session,EMessageMudule.EMessage message);

}