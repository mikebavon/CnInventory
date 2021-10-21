package com.cohort.action;


import com.cohort.ejb.ItemEjbI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    name="ItemSave",
    urlPatterns = "/item/save",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemSaveAction extends BaseServlet {

    @EJB
    private ItemEjbI itemEjb;

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(itemEjb.save(req.getParameterMap())));

    }
}
