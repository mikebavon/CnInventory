package com.cohort.action;

import com.cohort.ejb.CustomerBeanI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name="customer",
        urlPatterns = "/customer"
)
public class CustomerAction extends BaseServlet {

    @EJB
    private CustomerBeanI customerBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(customerBean.list()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(customerBean.save(req.getParameterMap())));
    }

}
