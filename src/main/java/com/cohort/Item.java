package com.cohort;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Item implements Servlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Item servlet initialized");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter display = res.getWriter();
        display.print("<html>");
        display.print("<body>");
        display.print("This will handle inventory items");
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
