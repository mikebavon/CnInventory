package com.cohort.dao;

import com.cohort.model.ItemCategory;

public interface ItemCategoryDaoI {

    ItemCategory save(ItemCategory category) throws Exception;

    ModelListWrapper<ItemCategory> list(ItemCategory filter, int start, int limit);

}
