package com.cohort.action;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemSaveAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");
            RequestDispatcher requestDispatcher;

            if (conn != null) {
                for (int x = 0; x < 3; x++) {
                    try {
                        PreparedStatement statement = conn.prepareStatement("insert into items(name,purchase_price,sale_price) values (?,?,?)");
                        statement.setString(1, req.getParameter("name" + x));
                        statement.setBigDecimal(2, new BigDecimal(req.getParameter("purchasePrice" + x)));
                        statement.setBigDecimal(3, new BigDecimal(req.getParameter("salePrice" + x)));
                        statement.executeUpdate();

                    } catch (SQLException throwables) {
                        System.out.println("Not inserted: " + throwables.getMessage());
                    }
                }

                requestDispatcher = req.getRequestDispatcher("/item/list");

            } else {
                requestDispatcher = req.getRequestDispatcher("/item/form");

            }

            requestDispatcher.forward(req, res);
    }
}
