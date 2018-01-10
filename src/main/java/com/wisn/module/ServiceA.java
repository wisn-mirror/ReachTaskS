package com.wisn.module;


import com.wisn.module.constant.CmdId;
import com.wisn.module.constant.ModuleId;
import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;

@SocketModule(module = ModuleId.module1)
public interface ServiceA {
    @SocketCmd(cmd = CmdId.cmd1)
    void printServiceA1();

    @SocketCmd(cmd = CmdId.cmd2)
    void printServiceA2();
}
