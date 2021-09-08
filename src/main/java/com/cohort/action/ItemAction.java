package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemAction extends HttpServlet {

    public void init(){
        System.out.println("Item Action Servlet is Loaded & Instatiated");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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

        display.print("<h2>HTML Forms</h2>\n"
            + "\n"
            + "<form action=\"./item\" method=\"POST\">\n");

        for (int cnt = 0; cnt<5; cnt++) {

            display.print("<hr/>");
            display.print("  <label for=\"fname\">Item Name" + (cnt+1) + ":</label><br>\n"
                + "  <input type=\"text\" id=\"name" + cnt + "\" name=\"name" + cnt + "\"><br>\n"
                + "  <label for=\"lname\">Purchase Price:</label><br>\n"
                + "  <input type=\"text\" id=\"purchasePrice" + cnt + "\" name=\"purchasePrice" + cnt + "\"><br><br>\n"

                + "  <label for=\"lname\">Selling Price:</label><br>\n"
                + "  <input type=\"text\" id=\"salePrice" + cnt + "\" name=\"salePrice" + cnt + "\"><br><br>\n");
        }


        display.print("<input type=\"submit\" value=\"Submit\">\n"
            + "</form> ");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        for (int x = 0; x<5; x++) {
            items.add(new Item(req.getParameter("name" + x), new BigDecimal(req.getParameter("purchasePrice" + x)),
                new BigDecimal(req.getParameter("salePrice" + x))));
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

    @Override
    public void destroy() {
        System.out.println("Killing servlet....");
    }

}
