package com.cohort.action;

import com.cohort.ejb.ItemCategoryBeanI;
import com.cohort.model.ItemCategory;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="ItemCategory",
    urlPatterns = "/itemcategory"
)
public class ItemCategoryAction extends BaseServlet {

    @EJB
    private ItemCategoryBeanI categoryBean;

    private ItemCategory itemCategory  = new ItemCategory();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        transform(itemCategory, req.getParameterMap());
        handleResponse(res, categoryBean.list(itemCategory, 0, 0).getList());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            transform(itemCategory, req.getParameterMap());
            categoryBean.save(itemCategory);

            handleResponse(res);

        }catch (Exception ex){
            exceptionResponse(res, false, ex.getMessage());

        }
    }

}
