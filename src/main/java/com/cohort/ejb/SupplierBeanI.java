package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.model.Supplier;

public interface SupplierBeanI {

    /**
     *
     * @param customer
     * @return
     * @throws Exception
     */
    Supplier save(Supplier customer) throws Exception;

    /**
     *
     * @param filter
     * @param start
     * @param limit
     * @return
     */
    ModelListWrapper<Supplier> list(Supplier filter, int start, int limit);
}
