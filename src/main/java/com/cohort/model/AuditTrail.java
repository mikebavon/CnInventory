package com.cohort.model;

import java.io.Serializable;
import java.util.Date;

public class AuditTrail implements Serializable {

    private String descr;

    private Date timeDone;

    public AuditTrail(){}

    public AuditTrail(String descr, Date timeDone){
        this.descr = descr;
        this.timeDone = timeDone;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getTimeDone() {
        return timeDone;
    }

    public void setTimeDone(Date timeDone) {
        this.timeDone = timeDone;
    }
}
