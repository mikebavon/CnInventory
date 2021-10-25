package com.cohort.action;

import com.cohort.ejb.ItemCategoryBeanI;

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

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(categoryBean.list()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(categoryBean.save(req.getParameterMap())));
    }

}
