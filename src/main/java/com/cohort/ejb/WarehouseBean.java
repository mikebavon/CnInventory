package com.cohort.ejb;

import com.cohort.model.ResultWrapper;
import com.cohort.model.Warehouse;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Stateless
public class WarehouseBean implements WarehouseBeanI{

    @PersistenceContext
    private EntityManager em;

    public ResultWrapper save(Map<String, String[]> params){
        ResultWrapper resultWrapper = new ResultWrapper();

        Warehouse warehouse = new Warehouse();
        try {
            BeanUtils.populate(warehouse, params);

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            warehouse = null;

        }

        if (warehouse == null){
            resultWrapper.setSuccess(false);
            return resultWrapper;
        }

        if (warehouse.getName() == null) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Name is required!");
            return resultWrapper;
        }

        em.merge(warehouse);

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT w FROM Warehouse w", Warehouse.class).getResultList());

        return resultWrapper;
    }
}
