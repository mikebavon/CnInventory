package com.cohort.dao;

import com.cohort.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ItemDao implements ItemDaoI {

    @PersistenceContext
    private EntityManager em;

    public Item save(Item item) throws Exception {
        return em.merge(item);
    }

    @SuppressWarnings("unchecked")
    public ModelListWrapper<Item> list(Item filter, int start, int limit) {
        ModelListWrapper<Item> results = new ModelListWrapper<Item>();

        String hql = "SELECT i FROM Item i WHERE i.id is not null";
        if (filter.getCategoryId() != 0)
            hql += " AND i.categoryId=" + filter.getCategoryId();

        if (filter.getWarehouseId() != 0)
            hql += " AND i.warehouseId=" + filter.getWarehouseId();

        Query query = em.createQuery(hql, Item.class);

        if (start > 0)
            query.setFirstResult(start);

        if (limit > 0)
            query.setMaxResults(limit);

        List<Item> items = query.getResultList();
        System.out.println(items.size());

        results.setList(items);

        return results;
    }
}