package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemAction implements Servlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Item servlet initialized");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Bread", BigDecimal.valueOf(70), BigDecimal.valueOf(75)));
        items.add(new Item("Milk", BigDecimal.valueOf(100), BigDecimal.valueOf(110)));
        items.add(new Item("Salt", BigDecimal.valueOf(30), BigDecimal.valueOf(40)));
        items.add(new Item("Maize Flour", BigDecimal.valueOf(200), BigDecimal.valueOf(220)));
        items.add(new Item("Sugar", BigDecimal.valueOf(250), BigDecimal.valueOf(300)));

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

        display.print("Items<br/>");
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

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("Servlet removed!!!.. container shutting down");
    }
}
