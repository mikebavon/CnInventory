package com.cohort.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultWrapper implements Serializable {

    private List<Item> list = new ArrayList<Item>();

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
