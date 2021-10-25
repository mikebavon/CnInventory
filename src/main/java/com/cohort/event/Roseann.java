package com.cohort.event;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class Roseann {

    public void sendMessage(@Observes Sms sms){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("This will send roseann a message whenever an item is created");
    }
}
