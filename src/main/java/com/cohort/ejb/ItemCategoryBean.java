package com.cohort.ejb;

import com.cohort.model.ItemCategory;
import com.cohort.model.ResultWrapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Stateless
public class ItemCategoryBean implements ItemCategoryBeanI{

    @PersistenceContext
    private EntityManager em;

    public ResultWrapper save(Map<String, String[]> params){
        ResultWrapper resultWrapper = new ResultWrapper();

        ItemCategory itemCategory = new ItemCategory();
        try {
            BeanUtils.populate(itemCategory, params);

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            itemCategory = null;

        }

        if (itemCategory == null){
            resultWrapper.setSuccess(false);
            return resultWrapper;
        }

        if (itemCategory.getName() == null) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("Name is required!");
            return resultWrapper;
        }

        em.merge(itemCategory);

        return resultWrapper;
    }

    public ResultWrapper list(){

        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.setList(em.createQuery("SELECT i FROM ItemCategory i", ItemCategory.class).getResultList());

        return resultWrapper;
    }
}
