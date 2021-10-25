package com.cohort.ejb;

import com.cohort.model.AuditTrail;
import com.cohort.model.ResultWrapper;
import com.cohort.model.Supplier;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.Map;

@Stateless
public class SupplierBean implements SupplierBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    public ResultWrapper save(Map<String, String[]> params){
        ResultWrapper resultWrapper = new ResultWrapper();

        Supplier supplier = new Supplier();

        try {
            BeanUtils.populate(supplier, params);

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            supplier = null;

        }

        if (supplier == null){
            resultWrapper.setSuccess(false);
            return resultWrapper;
        }

        if (supplier.getName() == null) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Name is required!");
            return resultWrapper;
        }

        supplier = em.merge(supplier);
        auditTrailEvent.fire(new AuditTrail("Created Item Category " + supplier.getName() + " Id: " + supplier.getId(), new Date()));

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT s FROM Supplier s", Supplier.class).getResultList());

        return resultWrapper;
    }
}
