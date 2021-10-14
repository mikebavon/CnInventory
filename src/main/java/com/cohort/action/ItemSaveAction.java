package com.cohort.action;


import com.cohort.dao.BaseDao;
import com.cohort.dao.BaseDaoI;
import com.cohort.model.Item;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    name="ItemSave",
    urlPatterns = "/item/save",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemSaveAction extends BaseServlet {

    @Inject
    private BaseDaoI baseDao;

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        Item item = new Item();
        try {
            BeanUtils.populate(item, req.getParameterMap());

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            item = null;

        }

        if (item == null){
            resultWrapper.setSuccess(false);
            res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
            return;

        }

        try {
            List<Object> params = new ArrayList<Object>();
            params.add(item.getName());
            params.add(item.getPurchasePrice());
            params.add(item.getSalePrice());

            baseDao.save("insert into items(name,purchase_price,sale_price) values (?,?,?)", params);

        } catch (Exception ex) {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage(ex.getMessage());
        }

        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
    }
}
