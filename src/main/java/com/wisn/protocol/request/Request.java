package com.wisn.protocol.request;


import com.wisn.protocol.ConstantValues;

import java.util.Arrays;

public class Request {
    private int TAG = ConstantValues.MESSAGE_HEADTAG;//int的最小值
    private short module; //模块号
    private short cmd;  //命令号
    private byte[] data;

    public static Request valueOf(short module, short cmd, byte[] data) {
        Request request = new Request();
        request.setModule(module);
        request.setCmd(cmd);
        request.setData(data);
        return request;
    }

    public short getModule() {
        return module;
    }

    public void setModule(short module) {
        this.module = module;
    }

    public short getCmd() {
        return cmd;
    }

    public void setCmd(short cmd) {
        this.cmd = cmd;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getTAG() {
        return TAG;
    }

    public void setTAG(int TAG) {
        this.TAG = TAG;
    }

    public int getDataLength() {
        if (this.data == null || this.data.length == 0) {
            return 0;
        }
        return this.data.length;
    }

    @Override
    public String toString() {
        return "Request{" +
                "TAG=" + TAG +
                ", module=" + module +
                ", cmd=" + cmd +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
