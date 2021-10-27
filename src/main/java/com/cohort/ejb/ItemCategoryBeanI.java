package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.model.ItemCategory;

public interface ItemCategoryBeanI {

    /**
     *
     * @param itemCategory
     * @return
     * @throws Exception
     */
    ItemCategory save(ItemCategory itemCategory) throws Exception;

    /**
     *
     * @param filter
     * @param start
     * @param limit
     * @return
     */
    ModelListWrapper<ItemCategory> list(ItemCategory filter, int start, int limit);
}
