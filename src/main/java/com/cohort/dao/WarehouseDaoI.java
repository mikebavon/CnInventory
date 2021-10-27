package com.cohort.dao;

import com.cohort.model.Warehouse;

public interface WarehouseDaoI {

    Warehouse save(Warehouse warehouse) throws Exception;

    ModelListWrapper<Warehouse> list(Warehouse filter, int start, int limit);

}
