package com.cohort.action;


import com.cohort.model.Item;
import com.cohort.model.SaveResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(
    name="ItemSave",
    urlPatterns = "/item/save",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemSaveAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        String msg = "Done";

        Item item = new Item();
        try {
            BeanUtils.populate(item, req.getParameterMap());

        }catch (Exception ex){
            msg = ex.getMessage();
            item = null;
        }

        if (item == null){
            res.getWriter().print(new ObjectMapper().writeValueAsString(new SaveResponse(true, msg)));
            return;
        }

        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        if (conn != null) {
            try {
                PreparedStatement statement = conn.prepareStatement("insert into items(name,purchase_price,sale_price) values (?,?,?)");
                statement.setString(1, item.getName());
                statement.setBigDecimal(2, item.getPurchasePrice());
                statement.setBigDecimal(3, item.getSalePrice());
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/item/form");
                requestDispatcher.forward(req, res);

            }

            res.getWriter().print(new ObjectMapper().writeValueAsString(new SaveResponse(true, "Done")));

        } else {
            res.getWriter().print(new ObjectMapper().writeValueAsString(new SaveResponse(false, "No connection")));

        }
    }
}
