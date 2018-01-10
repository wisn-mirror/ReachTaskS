package com.wisn.module;


import com.wisn.module.constant.CmdId;
import com.wisn.module.constant.ModuleId;
import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;

@SocketModule(module = ModuleId.module2)
public interface ServiceB {
    @SocketCmd(cmd = CmdId.cmd1)
    void printServiceB1();

    @SocketCmd(cmd = CmdId.cmd2)
    void printServiceB2();
}
