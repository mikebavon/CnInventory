package com.cohort.action;

import com.cohort.ejb.SupplierBeanI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="supplier",
    urlPatterns = "/supplier"
)
public class SupplierAction extends BaseServlet {

    @EJB
    private SupplierBeanI supplierBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(supplierBean.list()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(supplierBean.save(req.getParameterMap())));
    }

}
