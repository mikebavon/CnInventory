package com.cohort.dao;

import com.cohort.model.Customer;

public interface CustomerDaoI  {

    Customer save(Customer customer) throws Exception;

    ModelListWrapper<Customer> list(Customer filter, int start, int limit);

}
