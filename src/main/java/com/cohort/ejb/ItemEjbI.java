package com.cohort.ejb;

import com.cohort.model.ResultWrapper;

import java.util.Map;

public interface ItemEjbI {
    ResultWrapper save(Map<String, String[]> params);

    ResultWrapper list(Map<String, String[]> params);
}
