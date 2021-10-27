package com.cohort.dao;

import com.cohort.model.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class WarehouseDao implements WarehouseDaoI {

    @PersistenceContext
    private EntityManager em;

    public Warehouse save(Warehouse warehouse) throws Exception {
        return em.merge(warehouse);
    }

    @SuppressWarnings("unchecked")
    public ModelListWrapper<Warehouse> list(Warehouse filter, int start, int limit) {
        ModelListWrapper<Warehouse> results = new ModelListWrapper<Warehouse>();

        String hql = "SELECT w FROM Warehouse w WHERE w.id is not null";

        Query query = em.createQuery(hql, Warehouse.class);

        if (start > 0)
            query.setFirstResult(start);

        if (limit > 0)
            query.setMaxResults(limit);

        List<Warehouse> items = query.getResultList();

        results.setList(items);

        return results;
    }
}
