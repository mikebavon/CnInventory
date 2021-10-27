package com.cohort.dao;

import com.cohort.model.ItemCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ItemCategoryDao implements ItemCategoryDaoI {

    @PersistenceContext
    private EntityManager em;

    public ItemCategory save(ItemCategory itemCategory) throws Exception {
        return em.merge(itemCategory);
    }

    @SuppressWarnings("unchecked")
    public ModelListWrapper<ItemCategory> list(ItemCategory filter, int start, int limit) {
        ModelListWrapper<ItemCategory> results = new ModelListWrapper<ItemCategory>();

        String hql = "SELECT i FROM ItemCategory i WHERE i.id is not null";

        Query query = em.createQuery(hql, ItemCategory.class);

        if (start > 0)
            query.setFirstResult(start);

        if (limit > 0)
            query.setMaxResults(limit);

        List<ItemCategory> items = query.getResultList();

        results.setList(items);

        return results;
    }
}
