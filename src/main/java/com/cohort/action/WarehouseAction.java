package com.cohort.action;

import com.cohort.ejb.WarehouseBeanI;
import com.cohort.model.Warehouse;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="warehouse",
    urlPatterns = "/warehouse"
)
public class WarehouseAction extends BaseServlet {

    @EJB
    private WarehouseBeanI warehouseBean;

    private Warehouse warehouse  = new Warehouse();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        transform(warehouse, req.getParameterMap());
        handleResponse(res, warehouseBean.list(warehouse, 0, 0).getList());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            transform(warehouse, req.getParameterMap());
            warehouseBean.save(warehouse);

            handleResponse(res);

        }catch (Exception ex){
            exceptionResponse(res, false, ex.getMessage());

        }
    }

}
