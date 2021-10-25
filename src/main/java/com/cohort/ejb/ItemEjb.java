package com.cohort.ejb;

import com.cohort.event.Sms;
import com.cohort.model.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.Map;

@Stateless
public class ItemEjb implements ItemEjbI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<Sms> smsEvent;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    public ResultWrapper save(Map<String, String[]> params){
        ResultWrapper resultWrapper = new ResultWrapper();

        Item item = new Item();
        try {
            BeanUtils.populate(item, params);

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            item = null;

        }

        if (item == null){
            resultWrapper.setSuccess(false);
            return resultWrapper;
        }

        if (item.getName() == null || item.getPurchasePrice() == null || item.getSalePrice() == null) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Name, purchase price and sales price is required!");
            return resultWrapper;
        }

        if (item.getPurchasePrice().compareTo(item.getSalePrice()) > 0){
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Sales price cannot be less than purchase price!!");
            return resultWrapper;
        }

        if (item.getCategoryId() > 0)
            item.setCategory(em.find(ItemCategory.class, item.getCategoryId()));

        if (item.getWarehouseId() > 0)
            item.setWarehouse(em.find(Warehouse.class, item.getWarehouseId()));

        item = em.merge(item);

        smsEvent.fire(new Sms("0720893752", " Item created is " + item.getName()));
        auditTrailEvent.fire(new AuditTrail("Created Item " + item.getName() + " Id: " + item.getId(), new Date()));

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT i FROM Item i", Item.class).getResultList());

        return resultWrapper;
    }
}
