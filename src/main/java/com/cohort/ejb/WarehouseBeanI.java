package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.model.Warehouse;

public interface WarehouseBeanI {

    /**
     *
     * @param warehouse
     * @return
     * @throws Exception
     */
    Warehouse save(Warehouse warehouse) throws Exception;

    /**
     *
     * @param filter
     * @param start
     * @param limit
     * @return
     */
    ModelListWrapper<Warehouse> list(Warehouse filter, int start, int limit);
}
