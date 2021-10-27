package com.cohort.dao;

import com.cohort.model.Supplier;

public interface SupplierDaoI {

    Supplier save(Supplier supplier) throws Exception;

    ModelListWrapper<Supplier> list(Supplier filter, int start, int limit);

}
