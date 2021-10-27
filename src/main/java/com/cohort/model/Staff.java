package com.cohort.model;

import javax.persistence.*;

@Entity
@Table(name = "inv_staff")
public class Staff extends BaseEntity {

    @Column(name = "staff_no")
    private String staffNo;

    @Column
    private String name;

    @Embedded
    private Address address;

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
