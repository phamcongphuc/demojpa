package com.cyber.demojpa.payload;

public class BasicReponse {
    private  int statsCode;
    private  String message;
    private Object data;

    public int getStatsCode() {
        return statsCode;
    }

    public void setStatsCode(int statsCode) {
        this.statsCode = statsCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
