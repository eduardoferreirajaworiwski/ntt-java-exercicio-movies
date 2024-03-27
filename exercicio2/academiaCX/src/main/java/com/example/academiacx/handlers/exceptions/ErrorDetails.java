package com.example.academiacx.handlers.exceptions;

public class ErrorDetails {

    private String field;
    private Long code;
    private String title;
    private Long status;
    private Long timestamp;
    private String developerMessage;


    public ErrorDetails() {

    }

    public ErrorDetails(String title, Long code, Long status, Long timestamp, String developerMessage) {
        this.code = code;
        this.title = title;
        this.status = status;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public ErrorDetails(String title, Long code, Long status, Long timestamp, String developerMessage, String field) {
        this.code = code;
        this.title = title;
        this.status = status;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
        this.field =  field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
