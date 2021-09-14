package com.cohort.action;


import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="Item",
    urlPatterns = "/item",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/item/form");
        requestDispatcher.include(req, res);

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/item/save");
        requestDispatcher.forward(req, res);

    }

    /**
     * called when the server/web container is shutdown or a application is undeployed from the server/web container
     */
    @Override
    public void destroy() {
        System.out.println("Killing servlet....");
    }

}
