package com.cohort.ejb;

import com.cohort.dao.CustomerDaoI;
import com.cohort.dao.ModelListWrapper;
import com.cohort.model.AuditTrail;
import com.cohort.model.Customer;
import com.cohort.util.AppException;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class CustomerBean implements CustomerBeanI{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private CustomerDaoI customerDao;

    @Inject
    private Event<AuditTrail> auditTrailEvent;

    /**
     * @see CustomerBeanI#save(Customer)
     */
    public Customer save(Customer customer) throws Exception{
        if (customer == null)
            throw new AppException("Invalid customer details!!");

        customer = customerDao.save(customer);

        auditTrailEvent.fire(new AuditTrail("Created Customer " + customer.getName() + " Id: " + customer.getId(), new Date()));

        return customer;
    }

    /**
     * @see CustomerBeanI#list(Customer, int, int)
     */
    public ModelListWrapper<Customer> list(Customer filter, int start, int limit){
        return customerDao.list(filter, start, limit);
    }

}
