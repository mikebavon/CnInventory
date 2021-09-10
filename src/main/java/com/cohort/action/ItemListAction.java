package com.cohort.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ItemListAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
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
        display.print("<h1>" + req.getServletContext().getInitParameter("Application Name") + "</h1></br>");
        display.print("Version " + req.getServletContext().getInitParameter("Application Version") + "</br>");
        display.print("&nbsp");
        display.print("</br>");
        display.print("</br>");
        display.print(getServletConfig().getInitParameter("Page Name") + "</br>");

        display.print("<h3>Add Item</h3>\n"
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


        display.print("<input type=\"submit\" value=\"Submit\"></form> ");

    }
}
