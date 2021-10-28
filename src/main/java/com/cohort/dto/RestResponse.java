package com.cohort.dto;

import java.io.Serializable;

public class RestResponse implements Serializable {

    private boolean success = true;

    private String message = "Done";

    public RestResponse(){}

    public RestResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
