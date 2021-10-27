package com.cohort.dao;

import com.cohort.model.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class SupplierDao implements SupplierDaoI {

    @PersistenceContext
    private EntityManager em;

    public Supplier save(Supplier customer) throws Exception {
        return em.merge(customer);
    }

    @SuppressWarnings("unchecked")
    public ModelListWrapper<Supplier> list(Supplier filter, int start, int limit) {
        ModelListWrapper<Supplier> results = new ModelListWrapper<Supplier>();

        String hql = "SELECT s FROM Supplier s WHERE s.id is not null";

        Query query = em.createQuery(hql, Supplier.class);

        if (start > 0)
            query.setFirstResult(start);

        if (limit > 0)
            query.setMaxResults(limit);

        List<Supplier> items = query.getResultList();

        results.setList(items);

        return results;
    }
}
