package com.cohort.event;

import javax.ejb.Asynchronous;
import javax.enterprise.event.Observes;

public class SmsEvent2 {

    @Asynchronous
    public void sendSms(@Observes Sms sms){
        if (sms == null)
            return;


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Sent by : class 2");
        System.out.println("Phone to send: " + sms.getPhoneNo());
        System.out.println("Phone to send: " + sms.getMessage());

    }
}
