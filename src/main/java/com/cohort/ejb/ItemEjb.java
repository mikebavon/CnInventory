package com.cohort.ejb;

import com.cohort.dao.BaseDaoI;
import com.cohort.model.Item;
import com.cohort.model.ResultWrapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless
public class ItemEjb implements ItemEjbI{

    @Inject
    private BaseDaoI baseDao;

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

        try {
            List<Object> entityParam = new ArrayList<Object>();
            entityParam.add(item.getName());
            entityParam.add(item.getPurchasePrice());
            entityParam.add(item.getSalePrice());

            baseDao.save("insert into items(name,purchase_price,sale_price) values (?,?,?)", entityParam);

        } catch (Exception ex) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage(ex.getMessage());
        }

        return  resultWrapper;
    }

    public ResultWrapper list(){
        ResultWrapper resultWrapper = new ResultWrapper();

        List<Item> items = new ArrayList<Item>();

        try {
            ResultSet resultSet = baseDao.getList("select * from items");

            while(resultSet.next()){
                items.add(new Item((String)  resultSet.getString("name"),
                    (BigDecimal) resultSet.getBigDecimal("purchase_price"),
                    (BigDecimal) resultSet.getBigDecimal("sale_price")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        resultWrapper.setList(items);

        return resultWrapper;
    }
}
