package com.cohort.ejb;

import com.cohort.dao.ModelListWrapper;
import com.cohort.model.Customer;

public interface CustomerBeanI {

    /**
     *
     * @param customer
     * @return
     * @throws Exception
     */
    Customer save(Customer customer) throws Exception;

    /**
     *
     * @param filter
     * @param start
     * @param limit
     * @return
     */
    ModelListWrapper<Customer> list(Customer filter, int start, int limit);

}
