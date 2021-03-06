package com.cohort.model;

import javax.persistence.*;

@Entity
@Table(name = "inv_suppliers")
public class Supplier extends BaseEntity {

    @Column
    private String name;

    @Embedded
    private Address address;

    @Column
    @Enumerated(EnumType.STRING)
    private ClientType supplierType;

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

    public ClientType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(ClientType supplierType) {
        this.supplierType = supplierType;
    }
}
