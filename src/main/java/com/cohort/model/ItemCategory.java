package com.cohort.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inv_item_categories")
public class ItemCategory extends BaseEntity {

    public ItemCategory(){}

    public ItemCategory(String name){
        this.name = name;
    }

    @Column
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<Item>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
