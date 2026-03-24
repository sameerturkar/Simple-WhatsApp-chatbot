package com.example.whatsappchatbot.model;

public class MessageRequest {
    private String from;
    private String message;

    public MessageRequest() {
    }

    public MessageRequest(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
