package com.cohort.ejb;

import com.cohort.dao.ItemCategoryDaoI;
import com.cohort.dao.ModelListWrapper;
import com.cohort.model.*;
import com.cohort.util.AppException;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class ItemCategoryBean implements ItemCategoryBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ItemCategoryDaoI itemCategoryDao;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    /**
     * @see ItemCategoryBeanI#save(ItemCategory)
     */
    public ItemCategory save(ItemCategory itemCategory) throws Exception{
        if (itemCategory == null)
            throw new AppException("Invalid item category details!!");

        itemCategory = itemCategoryDao.save(itemCategory);

        auditTrailEvent.fire(new AuditTrail("Created Item Category " + itemCategory.getName() + " Id: "
            + itemCategory.getId(), new Date()));

        return itemCategory;
    }

    /**
     * @see ItemCategoryBeanI#list(ItemCategory, int, int)
     */
    public ModelListWrapper<ItemCategory> list(ItemCategory filter, int start, int limit){
        return itemCategoryDao.list(filter, start, limit);

    }
}
