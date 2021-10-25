package com.cohort.event;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class SmsEvent {

    @Asynchronous
    public void sendSms(@Observes Sms sms){
        if (sms == null)
            return;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Sent by : class 1");
        System.out.println("Phone to send: " + sms.getPhoneNo());
        System.out.println("Phone to send: " + sms.getMessage());

    }
}
