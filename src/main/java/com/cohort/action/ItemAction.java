package com.cohort.action;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ItemAction extends HttpServlet {

    /**
     * called on server/web container start up or on the first time a Servlet is created
     */
    public void init(){
        System.out.println("Item Action Servlet is Loaded & Instatiated");
    }

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
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/item/list");
        reqDispatcher.forward(req, res);
        display.print("</br>");
        display.print("The List Page is included....");
        display.print("</body>");
        display.print("</html>");
    }

    /**
     * Handles POST request, called/executed when submitting a form through post method
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/item/add");
        reqDispatcher.forward(req, res);

    }

    /**
     * called when the server/web container is shutdown or a application is undeployed from the server/web container
     */
    @Override
    public void destroy() {
        System.out.println("Killing servlet....");
    }

}
