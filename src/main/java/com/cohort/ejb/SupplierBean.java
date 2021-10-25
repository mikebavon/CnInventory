package com.cohort.ejb;

import com.cohort.model.ResultWrapper;
import com.cohort.model.Supplier;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Stateless
public class SupplierBean implements SupplierBeanI{

    @PersistenceContext
    private EntityManager em;

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

        em.merge(supplier);

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT s FROM Supplier s", Supplier.class).getResultList());

        return resultWrapper;
    }
}
