package com.cohort.event;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class VictorListener {

    @Asynchronous
    public void sendVictorCoolMessage(@Observes Sms sms){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Victor will receive a cool message whenever item is created!!");
    }

    @Asynchronous
    public void sendVictorAnotherCoolMessage(@Observes Sms sms){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("This is cool message because of how man u was beaten!!");
    }

    @Asynchronous
    public void sendVictorValentinveMessage(@Observes Sms sms){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Victor will receive a valentine message!!");
    }
}
