package com.cohort.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

    public Item(){}

    public Item(String name, BigDecimal purchasePrice, BigDecimal salePrice){
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    private int id;

    private String name;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", salePrice=" + salePrice +
                '}';
    }
}
