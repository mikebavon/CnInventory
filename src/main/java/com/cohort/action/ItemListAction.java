package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    name="ItemList",
    urlPatterns = "/item/list",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemListAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        try {
            PreparedStatement statement = conn.prepareStatement("select * from items");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                items.add(new Item((String)  resultSet.getString("name"),
                    (BigDecimal) resultSet.getBigDecimal("purchase_price"),
                    (BigDecimal) resultSet.getBigDecimal("sale_price")));
            }

            req.getSession().setAttribute("items", items);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        res.sendRedirect("../item.jsp");

        return;
    }
}
