package com.cohort.action;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ItemCategoryAction implements Servlet {
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter display = res.getWriter();
        display.print("<html>");
        display.print("<body>");
        display.print("This will handle inventory items category");
        display.print("</body>");
        display.print("</html>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}