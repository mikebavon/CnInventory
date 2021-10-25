package com.cohort.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inv_audit_trail")
public class AuditTrail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String descr;

    @Column(name = "time_done")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeDone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
