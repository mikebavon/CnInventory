package com.cohort.model;

import javax.persistence.*;

@Entity
@Table(name ="inv_warehouses")
public class Warehouse extends BaseEntity {

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
