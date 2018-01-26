package com.wisn.protocol.response;


import com.wisn.protocol.ConstantValues;
import com.wisn.protocol.request.Request;

import java.util.Arrays;

public class Response {
    private int TAG = ConstantValues.MESSAGE_HEADTAG;//int的最小值
    private short module; //模块号
    private short cmd;  //命令号
    private short resultCode;
    private byte[] data;

    public static Response valueOf(short module, short cmd,short resultCode, byte[] data) {
        Response Response = new Response();
        Response.setModule(module);
        Response.setCmd(cmd);
        Response.setResultCode(resultCode);
        Response.setData(data);
        return Response;
    }

    public static Response valueOf(Request request) {
        Response Response = new Response();
        Response.setModule(request.getModule());
        Response.setCmd(request.getCmd());
        Response.setData(request.getData());
        return Response;
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

    public short getResultCode() {
        return resultCode;
    }

    public void setResultCode(short resultCode) {
        this.resultCode = resultCode;
    }

    public int getDataLength() {
        if (this.data == null || this.data.length == 0) {
            return 0;
        }
        return this.data.length;
    }

    @Override
    public String toString() {
        return "Response{" +
                "TAG=" + TAG +
                ", module=" + module +
                ", cmd=" + cmd +
                ", resultCode=" + resultCode +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
