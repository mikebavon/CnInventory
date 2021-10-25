package com.cohort.ejb;

import com.cohort.model.ResultWrapper;

import java.util.Map;

public interface SupplierBeanI {


    ResultWrapper save(Map<String, String[]> params);

    ResultWrapper list();
}
