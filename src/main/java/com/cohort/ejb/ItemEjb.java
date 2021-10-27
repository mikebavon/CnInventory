package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.dao.ItemDaoI;
import com.cohort.event.Sms;
import com.cohort.model.*;
import com.cohort.util.AppException;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class ItemEjb implements ItemEjbI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<Sms> smsEvent;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    @Inject
    private ItemDaoI itemDao;

    /**
     * @see ItemEjbI#save(Item)
     */
    public Item save(Item item) throws Exception{
        if (item == null)
            throw new AppException("Invalid item details!!");

        if (item.getName() == null || item.getPurchasePrice() == null || item.getSalePrice() == null)
            throw new AppException("Name, purchase price and sales price is required!");

        if (item.getPurchasePrice().compareTo(item.getSalePrice()) > 0)
            throw new AppException("Sales price cannot be less than purchase price!!");

        if (item.getCategoryId() > 0)
            item.setCategory(em.find(ItemCategory.class, item.getCategoryId()));

        if (item.getWarehouseId() > 0)
            item.setWarehouse(em.find(Warehouse.class, item.getWarehouseId()));

        item = itemDao.save(item);

        smsEvent.fire(new Sms("0720893752", " Item created is " + item.getName()));
        auditTrailEvent.fire(new AuditTrail("Created Item " + item.getName() + " Id: " + item.getId(), new Date()));

        return item;
    }

    /**
     * @see ItemEjbI#list(Item, int, int) 
     */
    public ModelListWrapper<Item> list(Item filter, int start, int limit){
        System.out.println(filter.getCategoryId());
        System.out.println(filter.getWarehouseId());
        return itemDao.list(filter, start, limit);

    }
}
