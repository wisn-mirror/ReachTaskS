package com.wisn.protocol;

public interface ResponseCode {
    /**
     * 新消息
     */
    short newMessage = 10000;

    /**
     * 成功
     */
    short SUCCESS = 200;

    /**
     * 参数异常
     */
    short AGRUMENT_ERROR = 401;

    /**
     * 没有权限
     */
    short NO_AUTH = 403;

    /**
     * 找不到命令
     */
    short NO_INVOKER = 404;

    /**
     *服务器错误
     */
    short SERVER_EXCEPTION = 500;

    /**
     * 未知异常
     */
    short UNKOWN_EXCEPTION = -1;

}
