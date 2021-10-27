package com.cohort.model;

import javax.persistence.*;

@Entity
@Table(name = "inv_customers")
public class Customer extends BaseEntity {

    @Column
    private String name;

    @Embedded
    private Address address;

    @Column
    @Enumerated(EnumType.STRING)
    private ClientType customerType;

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

    public ClientType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(ClientType customerType) {
        this.customerType = customerType;
    }
}
