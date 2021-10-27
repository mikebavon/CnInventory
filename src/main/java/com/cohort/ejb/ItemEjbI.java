package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.model.Item;

public interface ItemEjbI {

    /**
     * this save items
     * @param item object to be persisted or saved
     * @return returns persisted item
     */
    Item save(Item item) throws Exception;

    /**
     *
     * @param filter
     * @param start
     * @param limit
     * @return
     * @throws Exception
     */
    ModelListWrapper<Item> list(Item filter, int start, int limit);

}
