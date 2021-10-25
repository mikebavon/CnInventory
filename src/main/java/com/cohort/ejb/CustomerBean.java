package com.cohort.ejb;

import com.cohort.model.AuditTrail;
import com.cohort.model.Customer;
import com.cohort.model.ResultWrapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.Map;

@Stateless
public class CustomerBean implements CustomerBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    public ResultWrapper save(Map<String, String[]> params){
        ResultWrapper resultWrapper = new ResultWrapper();

        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, params);

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            customer = null;

        }

        if (customer == null){
            resultWrapper.setSuccess(false);
            return resultWrapper;
        }

        if (customer.getName() == null) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Name is required!");
            return resultWrapper;
        }

        customer = em.merge(customer);
        auditTrailEvent.fire(new AuditTrail("Created Customer " + customer.getName() + " Id: " + customer.getId(), new Date()));

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT cust FROM Customer cust", Customer.class).getResultList());

        return resultWrapper;
    }
}
