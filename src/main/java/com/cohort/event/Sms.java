package com.cohort.event;

import java.io.Serializable;

public class Sms implements Serializable {

    private String phoneNo;

    private String message;

    public Sms(){}

    public Sms(String phoneNo, String message){
        this.phoneNo = phoneNo;
        this.message = message;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
