package com.cohort.action;

import com.cohort.ejb.CustomerBeanI;
import com.cohort.ejb.SupplierBeanI;
import com.cohort.model.Customer;
import com.cohort.model.Supplier;

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

    private Supplier supplier  = new Supplier();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        transform(supplier, req.getParameterMap());
        handleResponse(res, supplierBean.list(supplier, 0, 0).getList());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            transform(supplier, req.getParameterMap());
            supplierBean.save(supplier);

            handleResponse(res);

        }catch (Exception ex){
            exceptionResponse(res, false, ex.getMessage());

        }
    }

}
