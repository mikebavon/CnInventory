package com.cohort.action;

import com.cohort.model.ItemCategory;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    name="ItemCategory",
    urlPatterns = "/itemcategory",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemCategoryAction extends HttpServlet {

    public void init(){
        System.out.println("Item Action Servlet is Loaded & Instatiated");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<ItemCategory> categories = new ArrayList<ItemCategory>();
        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        try {
            PreparedStatement statement = conn.prepareStatement("select * from item_categories");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                categories.add(new ItemCategory((String)resultSet.getString("name")));
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

        display.print("Application Version" + req.getServletContext().getInitParameter("Application Version") + "<br>");
        display.print("Application Country" + req.getServletContext().getInitParameter("Built Country") + "<br>");
        display.print("Application Country " + getServletConfig().getInitParameter("Built Continent") + "<br>");

        display.print("Item Categories<br/>");
        display.print("<table>");
        display.print("<th>Name</th>");

        for (ItemCategory category : categories){
            display.print("<tr>");
            display.print("<td>" + category.getName() + "</td>");
            display.print("</tr>");
        }

        display.print("</table>");

        display.print("<h3>Add Item</h3><form action=\"./itemcategory\" method=\"POST\">\n");

            display.print("<hr/>");
            display.print("  <label for=\"fname\">Category Name:</label><br>\n"
                + "  <input type=\"text\" id=\"name\" name=\"name\"><br>\n");


        display.print("<input type=\"submit\" value=\"Submit\"></form></body></html>");

        display.print("</body>");
        display.print("</html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        if (conn != null) {
            try {
                PreparedStatement statement = conn.prepareStatement("insert into item_categories(name) values (?)");
                statement.setString(1, req.getParameter("name"));
                statement.executeUpdate();

            } catch (SQLException throwables) {
                System.out.println("Not inserted: " + throwables.getMessage());
            }

        } else {
            System.out.println("No connection!!");
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

        display.print("Application Version" + req.getServletContext().getInitParameter("Application Version") + "<br>");
        display.print("Application Country" + req.getServletContext().getInitParameter("Built Country") + "<br>");
        display.print("Application Country " + getServletConfig().getInitParameter("Built Continent") + "<br>");
        display.print("</body>");
        display.print("Saved Successfully! <a href=\"./itemcategory\">Go To Category List</a>");

        display.print("</html>");
    }

}
