package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.dao.SupplierDaoI;
import com.cohort.model.AuditTrail;
import com.cohort.model.Supplier;
import com.cohort.util.AppException;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class SupplierBean implements SupplierBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private SupplierDaoI supplierDao;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    /**
     * @see SupplierBeanI#save(Supplier)
     */
    public Supplier save(Supplier customer) throws Exception{
        if (customer == null)
            throw new AppException("Invalid supplier details!!");

        customer = supplierDao.save(customer);

        auditTrailEvent.fire(new AuditTrail("Created supplier " + customer.getName() + " Id: " + customer.getId(), new Date()));

        return customer;
    }

    /**
     * @see SupplierBeanI#list(Supplier, int, int)
     */
    public ModelListWrapper<Supplier> list(Supplier filter, int start, int limit){
        return supplierDao.list(filter, start, limit);
    }

}
