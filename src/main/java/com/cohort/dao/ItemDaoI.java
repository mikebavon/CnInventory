package com.cohort.dao;

import com.cohort.model.Item;

public interface ItemDaoI {

    Item save(Item item) throws Exception;

    ModelListWrapper<Item> list(Item filter, int start, int limit);

}
