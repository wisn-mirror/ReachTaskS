package com.wisn.http;

/**
 * 请求返回消息体
 * @param <T>
 */
public class HttpResponse<T> {
    public  int code;
    public String message;
    public T data;

    public HttpResponse() {
    }

    public HttpResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
