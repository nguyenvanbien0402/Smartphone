package com.example.shop_online.payload.response;

public class ResponseData {

    private int status;
    private boolean isSuccess;
    private String desc;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(int status, boolean isSuccess, String desc, Object data) {
        this.status = status;
        this.isSuccess = isSuccess;
        this.desc = desc;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
