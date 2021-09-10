package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ItemAddAction extends HttpServlet {

    /**
     * Handles POST request, called/executed when submitting a form through post method
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        for (int x = 0; x<5; x++) {
            items.add(new Item(req.getParameter("name" + x), new BigDecimal(req.getParameter("purchasePrice" + x)),
                    new BigDecimal(req.getParameter("salePrice" + x))));
        }

        Enumeration params = req.getParameterNames();

        while(params.hasMoreElements()){
            String paramName = (String) params.nextElement();
            System.out.println(paramName + "=" + req.getParameter(paramName));
        }

        PrintWriter display = res.getWriter();
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


    }
}
