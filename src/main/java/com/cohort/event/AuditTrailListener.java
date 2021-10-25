package com.cohort.event;

import com.cohort.model.AuditTrail;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class AuditTrailListener {

    @Asynchronous
    public void saveAuditTrail(@Observes AuditTrail auditTrail){
        System.out.println(auditTrail.getDescr());
        System.out.println(auditTrail.getTimeDone());

        System.out.println("We will save audit trail....");
    }
}
