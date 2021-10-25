package com.cohort.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inv_item_categories")
public class ItemCategory implements Serializable {

    public ItemCategory(){}

    public ItemCategory(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

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
}
