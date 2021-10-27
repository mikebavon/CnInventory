package com.cohort.action;

import com.cohort.ejb.CustomerBeanI;
import com.cohort.model.Customer;

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

    private Customer customer  = new Customer();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        transform(customer, req.getParameterMap());
        handleResponse(res, customerBean.list(customer, 0, 0).getList());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            transform(customer, req.getParameterMap());
            customerBean.save(customer);

            handleResponse(res);

        }catch (Exception ex){
            exceptionResponse(res, false, ex.getMessage());

        }
    }

}
