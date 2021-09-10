package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemListAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        try {
            PreparedStatement statement = conn.prepareStatement("select * from items");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                items.add(new Item((String)resultSet.getString("name"),
                    (BigDecimal) resultSet.getBigDecimal("purchase_price"),
                    (BigDecimal) resultSet.getBigDecimal("sale_price")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter display = res.getWriter();
        display.print("<html>");
        display.print("<head>"
                + "<style>"
                + "table, th, td {"
                + "  border: 1px solid black;"
                + "  width: 100%;"
                + "  border-collapse: collapse;"
                + "  background-color: #96D4D4;"
                + "}"
                + "</style>"
                + "</head>");
        display.print("<body>");
        display.print("<h1>" + req.getServletContext().getInitParameter("Application Name") + "</h1></br>");
        display.print("Version " + req.getServletContext().getInitParameter("Application Version") + "</br>");
        display.print("&nbsp");
        display.print("</br>");
        display.print("</br>");
        display.print(getServletConfig().getInitParameter("Page Name") + "</br>");

        display.print("<h3>Item List</h3><br/>");
        display.print("<table>");
        display.print("<th>Item</th>");
        display.print("<th>Purchase Price</th>");
        display.print("<th>Selling Price</th>");

        for (Item item : items){
            display.print("<tr>");
            display.print("<td>" + item.getName() + "</td>");
            display.print("<td>" + item.getPurchasePrice() + "</td>");
            display.print("<td>" + item.getSalePrice() + "</td>");
            display.print("</tr>");
        }

        display.print("</table>");
        display.print("</body>");
        display.print("</html>");

    }
}
