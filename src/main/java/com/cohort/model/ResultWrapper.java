package com.cohort.model;

import java.io.Serializable;
import java.util.List;

public class ResultWrapper<T> implements Serializable {

    private List<T> list;

    private boolean success = true;

    private String message = "Done";

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
