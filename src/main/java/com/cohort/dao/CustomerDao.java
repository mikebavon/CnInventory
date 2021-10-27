package com.cohort.dao;

import com.cohort.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomerDao implements CustomerDaoI {

    @PersistenceContext
    private EntityManager em;

    public Customer save(Customer customer) throws Exception {
        return em.merge(customer);
    }

    @SuppressWarnings("unchecked")
    public ModelListWrapper<Customer> list(Customer filter, int start, int limit) {
        ModelListWrapper<Customer> results = new ModelListWrapper<Customer>();

        String hql = "SELECT c FROM Customer c WHERE c.id is not null";

        Query query = em.createQuery(hql, Customer.class);

        if (start > 0)
            query.setFirstResult(start);

        if (limit > 0)
            query.setMaxResults(limit);

        List<Customer> items = query.getResultList();

        results.setList(items);

        return results;
    }
}
