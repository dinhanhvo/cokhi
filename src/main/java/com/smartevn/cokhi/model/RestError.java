package com.smartevn.cokhi.model;

public class RestError {

    private String code;
    private int statusCode;
    private String userMessage;
    private String internalMessage;
    private boolean raw;
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getUserMessage() {
        return userMessage;
    }
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public boolean isRaw() {
        return raw;
    }
    public void setRaw(boolean raw) {
        this.raw = raw;
    }
}
