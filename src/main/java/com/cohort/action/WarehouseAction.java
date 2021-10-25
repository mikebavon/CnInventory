package com.cohort.action;

import com.cohort.ejb.WarehouseBeanI;

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

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(warehouseBean.list()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(warehouseBean.save(req.getParameterMap())));
    }

}
